layui.use(['table', 'layer', 'upload', 'jquery', 'form', 'element'], function () {
    var table = layui.table;
    var layer = layui.layer;
    var $ = layui.jquery;
    var form = layui.form;
    var element = layui.element
    var upload = layui.upload
    var curIndex;

    ///staff
    table.render({
        elem: '#staff_form'
        , url: '/staff/staffList'
        , toolbar: '#toolbar_head'
        ,cellMinWidth:100
        , title: '用户数据表'
        , id: 'staffTable'
        , cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                , {
                field: 'staff_id',
                title: '员工id',
                width: 100,
                fixed: 'left',
                unresize: true,
                sort: true,
                totalRowText: '合计'
            }
                , {field: 'department_name', title: '所属部门'}
                , {field: 'staff_bankCard', title: '银行卡号'}
                , {field: 'staff_idCard', title: '身份证号'}
                , {field: 'staff_name', title: '姓名', totalRow: true}
                , {field: 'staff_phone', title: '电话'}
                , {field: 'staff_addr', title: '住址', totalRow: true}
                , {
                field: 'jointime',
                title: '入职时间',
                templet: '<div>{{layui.util.toDateString(d.jointime,"yyyy-MM-dd")}}</div>'
            }
                , {fixed: 'right', title: '操作', toolbar: '#barDemo'}
            ]
        ]
        , page: true
        , limits: [5, 10, 15, 70]
        , limit: 5
        , request: {
            pageName: 'currentPageNo' //页码的参数名称，默认：page
            , limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
    });

    //工具栏事件
    table.on('toolbar(staff_filter)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'addStaff':
                curIndex = layer.open({
                    type: 1,
                    area: ['600px', '600px'],
                    title: "增加员工",
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: false,
                    content: $('#staff_add')
                });
                break;
        };
    });


    table.on('tool(staff_filter)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        switch (layEvent) {
            case 'edit':
                curIndex = layer.open({
                    type: 1,
                    area: ['600px', '600px'],
                    title: "修改信息",
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: false,
                    content: $('#staff_edit')
                });
                //表单值
                form.val("staff_form", {
                    // "哈哈哈":data.staff_id,
                    "staff_id": data.staff_id,
                    "department_name": data.department_name,
                    "staff_bankCard": data.staff_bankCard,
                    "staff_idCard": data.staff_idCard,
                    "staff_name": data.staff_name,
                    "staff_phone": data.staff_phone,
                    "staff_addr": data.staff_addr,
                    "jointime": layui.util.toDateString(data.jointime, "yyyy-MM-dd")
                })
                break;
            case 'delete':
                // console.log(obj.data.staff_id)
                layer.confirm('确认删除？', function (index) {
                    $.ajax({
                        type: 'POST',
                        url: '/staff/delete',
                        data: {staffId: obj.data.staff_id},
                        success: function (msg) {
                            if (msg == 'success') {
                                obj.del;
                                layer.close(index);
                                table.reload('staffTable');
                                layer.msg("删除成功", {icon: 6});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    })
                })
                break;
        }
    });

    form.on('submit(add)', function (data) {
        // console.log(data.field)
        $.ajax({
            url: '/staff/add',
            type: "POST",
            data: {staffStr: JSON.stringify(data.field)},
            success: function (msg) {
                if (msg == 'success') {
                    layer.msg("添加成功！", {icon: 6});
                    layer.close(curIndex);
                    table.reload('staffTable');
                } else {
                    layer.close(curIndex);
                    layer.msg("添加失败！", {icon: 5})
                }
            }
        })
        return false;
    })
    form.on('submit(update_staff)', function (data) {
        $.ajax({
            url: '/staff/update',
            type: "POST",
            data: {staffStr: JSON.stringify(data.field)},
            success: function (msg) {
                if (msg == 'success') {
                    layer.msg("更新成功！", {icon: 6});
                    layer.close(curIndex);
                    table.reload('staffTable');
                } else {
                    layer.close(curIndex);
                    layer.msg("更新失败！", {icon: 5})
                }
            }
        })
        return false;
    })

    ///car
    //选完文件后不自动上传
    upload.render({
        elem: '#pickFile'
        , url: '/car/upload'
        , auto: false
        //,multiple: true
        , bindAction: '#upload'
        , before: function (obj) {
            this.data = {"carId": $("#car_id_image").val()}
            // this.data={"car_id":}
        }
        , done: function (res) {
            if (res.code == 0) {
                layer.close(curIndex);
                table.reload('carTable');
                layer.alert("上传成功！",{icon:6})
            } else {
                layer.alert("上传失败！",{icon:5});
            }
        }
    });
    table.render({
        elem: '#car_form'
        , url: '/car/carList'
        , toolbar: '#toolbar_head'
        , title: '用户数据表'
        ,cellMinWidth:100
        , id: 'carTable'
        , cols: [
            [
                {type: 'checkbox', fixed: 'left'}
                , {
                field: 'car_id',
                title: '汽车编号',
                width: 100,
                fixed: 'left',
                unresize: true,
                sort: true,
                totalRowText: '合计'
            }
                , {field: 'car_type', title: '汽车类型', }
                , {field: 'car_name', title: '汽车名', }
                , {field: 'car_color', title: '汽车颜色',}
                , {field: 'car_stock', title: '库存量',  totalRow: true}
                , {field: 'manufactor_name', title: '生产商'}
                , {
                field: 'manufactor_date',
                title: '出厂时间',
                width: 120,
                templet: '<div>{{layui.util.toDateString(d.manufactor_date,"yyyy-MM-dd")}}</div>'
            }
                , {field: 'manufactor_price', title: '出厂价格',  totalRow: true}
                , {field: 'car_image', title: '汽车照片',templet: '#imgTemp'}
                , {fixed: 'right', title: '操作', toolbar: '#barDemo', width: 250}
            ]
        ]
        , page: true
        , limits: [5, 10, 15, 70]
        , limit: 5
        , request: {
            pageName: 'currentPageNo' //页码的参数名称，默认：page
            , limitName: 'pageSize' //每页数据量的参数名，默认：limit
        }
    });

    //工具栏事件
    table.on('toolbar(car_filter)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'getCheckData':
                var data = checkStatus.data;
                layer.alert(JSON.stringify(data));
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'addCar':
                curIndex = layer.open({
                    type: 1,
                    area: ['600px', '600px'],
                    title: "增加车辆信息",
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: false,
                    content: $('#car_add')
                });
        };
    });

    table.on('tool(car_filter)', function (obj) {
        var data = obj.data;
        var layEvent = obj.event;
        switch (layEvent) {
            case 'edit':
                curIndex = layer.open({
                    type: 1,
                    area: ['600px', '600px'],
                    title: "修改信息",
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: false,
                    content: $('#car_edit')
                });
                //表单值
                form.val("car_form", {
                    // "哈哈哈":data.staff_id,
                    "car_id": data.car_id,
                    "car_type": data.car_type,
                    "car_name": data.car_name,
                    "car_color": data.car_color,
                    "car_stock": data.car_stock,
                    "manufactor_name": data.manufactor_name,
                    "manufactor_date": layui.util.toDateString(data.manufactor_date, "yyyy-MM-dd"),
                    "manufactor_price": data.manufactor_price
                })
                break;
            case 'delete':
                // console.log(obj.data.staff_id)
                layer.confirm('确认删除？', function (index) {
                    $.ajax({
                        type: 'GET',
                        url: '/car/delete',
                        data: {carId: obj.data.car_id},
                        success: function (msg) {
                            if (msg == 'success') {
                                obj.del;
                                layer.close(index);
                                table.reload('carTable');
                                layer.msg("删除成功", {icon: 6});
                            } else {
                                layer.msg("删除失败", {icon: 5});
                            }
                        }
                    })
                })
                break;

            case "upload":
                curIndex = layer.open({
                    type: 1,
                    area: ['300px', '300px'],
                    title: "增加/修改图片信息",
                    fixed: false, //不固定
                    maxmin: true,
                    shadeClose: false,
                    content: $('#car_image')
                });
                //表单值
                form.val("upload_image", {
                    "car_id": data.car_id
                })
        }
    });

    form.on('submit(add)', function (data) {
        // console.log(data.field)
        $.ajax({
            url: '/car/add',
            type: "POST",
            data: {addCarStr: JSON.stringify(data.field)},
            success: function (msg) {
                if (msg == 'success') {
                    layer.msg("添加成功！", {icon: 6});
                    layer.close(curIndex);
                    table.reload('carTable');
                } else {
                    layer.close(curIndex);
                    layer.msg("添加失败！", {icon: 5})
                }
            }
        })
        return false;
    });

    form.on('submit(update)', function (data) {
        $.ajax({
            url: '/car/update',
            type: "POST",
            data: {carStr: JSON.stringify(data.field)},
            success: function (msg) {
                if (msg == 'success') {
                    layer.msg("更新成功！", {icon: 6});
                    layer.close(curIndex);
                    table.reload('carTable');
                } else {
                    layer.close(curIndex);
                    layer.msg("更新失败！", {icon: 5})
                }
            }
        })
        return false;
    })
})

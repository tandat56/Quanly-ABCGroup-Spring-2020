<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file="/common/taglib.jsp"%>
<c:url var="newURL" value="/quan-tri/bai-viet/danh-sach"/>
<c:url var="editNewURL" value="/quan-tri/bai-viet/chinh-sua"/>
<c:url var="newAPI" value="/api/new"/>
<html>
<head>
<title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
	<div class="main-content-inner">
		<div class="breadcrumbs" id="breadcrumbs">
			<script type="text/javascript">
				try {
					ace.settings.check('breadcrumbs', 'fixed')
				} catch (e) {
				}
			</script>

			<ul class="breadcrumb">
				<li><i class="ace-icon fa fa-home home-icon"></i> <a href="<c:url value='/trang-chu'/>">Home</a>
				</li>

				<li><a href="<c:url value='/trang-chu'/>">Forms</a></li>
				<li class="active">Form Elements</li>
			</ul>
			<!-- /.breadcrumb -->
		</div>
		<div class="page-content">
			<div class="row">
				<div class="col-xs-12">
					<c:if test="${not empty message}">
						<div class="alert alert-${alert}">
  							${message}
						</div>
					</c:if>
					<form:form class="form-horizontal" role="form" id="formSubmit" modelAttribute="model">
						<div class="form-group">
							  <label for="departCode" class="col-sm-3 control-label no-padding-right">Phòng ban:</label>
							  <div class="col-sm-9">
							  	 <form:select path="departCode" id="departCode">
							  	 	<form:option value="" label="-- Chọn phòng ban --"/>
							  	 	<!-- spring yêu cầu truyền vào một cái Map  -->
							  	 	<form:options items="${departs}"/>
							  	 </form:select>
							  </div>
						</div>
						<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Tên nhân viên</label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="col-xs-10 col-sm-5"/>
								</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right">Ảnh đại diện:</label>
							<div class="col-sm-4">
								<input type="file" id="uploadImage"/>
							</div>
							<div class="col-sm-5" style="margin-bottom: 10px">
								<c:if test="${not empty model.photo}">
									<c:set var="image" value="/repository/${model.photo}"/>
									<img src="${image}" id="viewImage" width="300px" height="300px">
								</c:if>
								<c:if test="${empty model.photo}">
									<img src="<c:url value='/template/image/default.png'/>" id="viewImage" width="300px" height="300px">
								</c:if>
							</div>
							<br/>
						</div>
						<div class="form-group">
						  	<label for="note" class="col-sm-3 control-label no-padding-right">Mô tả ngắn:</label>
						  	<div class="col-sm-9">
						  		<form:textarea path="note" rows="5" cols="10" cssClass="form-control" id="note"/>
						  	</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Email</label>
							<div class="col-sm-9">
								<form:input path="email" cssClass="col-xs-10 col-sm-5"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Phone</label>
							<div class="col-sm-9">
								<form:input path="phone" cssClass="col-xs-10 col-sm-5"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Birth Date</label>
							<div class="col-sm-9">
								<form:input path="brithday" cssClass="col-xs-10 col-sm-5"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Salary</label>
							<div class="col-sm-9">
								<form:input path="salary" cssClass="col-xs-10 col-sm-5"/>
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">Giới tính</label>
							<div class="col-sm-9">
								<form:radiobutton path="sex" value="MALE"/>Nam
								<form:radiobutton path="sex" value="FEMALE"/>Nữ
							</div>
						</div>
						<form:hidden path="id" id="newId"/>
						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
											<c:if test="${not empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Cập nhật nhân viên
												</button>
											</c:if>
											<c:if test="${empty model.id}">
												<button class="btn btn-info" type="button" id="btnAddOrUpdateNew">
													<i class="ace-icon fa fa-check bigger-110"></i>
													Thêm nhân viên
												</button>
											</c:if>

											&nbsp; &nbsp; &nbsp;
											<button class="btn" type="reset">
												<i class="ace-icon fa fa-undo bigger-110"></i>
												Hủy
											</button>
							</div>		
						</div>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</div>	

<script>
    var photoBase64 = '';
    var photoName = '';
	 $('#btnAddOrUpdateNew').click(function (e) {
	    e.preventDefault();
	    var data = {};
	    var formData = $('#formSubmit').serializeArray();
	    $.each(formData, function (i, v) {
	        data[""+v.name+""] = v.value;
	    });
         if (photoBase64 != '') {
             data['photoBase64'] = photoBase64;
             data['photoName'] = photoName;
         }
	    var id = $('#newId').val();
	    if (id == "") {
	    	addNew(data);
	    } else {
	    	updateNew(data);
	    }
	})
	function addNew(data) {
		$.ajax({
	        url: '${newAPI}',
	        type: 'POST',
	        contentType: 'application/json',
	        /*chuyển đổi từ JSObject qua Json  */
	        data: JSON.stringify(data),
	        dataType: 'json',
	        success: function (result) {
	        	window.location.href = "${editNewURL}?id="+result.id+"&message=insert_success";
	        },
	        error: function (error) {
	        	window.location.href = "${newURL}?page=1&limit=2&message=error_system";
	        }
	    });
	}
	
	function updateNew(data) {
		$.ajax({
	        url: '${newAPI}',
	        type: 'PUT',
	        contentType: 'application/json',
	        data: JSON.stringify(data),
	        dataType: 'json',
	        success: function (result) {
	        	window.location.href = "${editNewURL}?id="+result.id+"&message=update_success";
	        },
	        error: function (error) {
	        	window.location.href = "${editNewURL}?id="+result.id+"&message=error_system";
	        }
	    });
	}

    $('#uploadImage').change(function (event) {
        var reader = new FileReader();
        var file = $(this)[0].files[0];
        reader.onload = function(e){
            photoBase64 = e.target.result;
            photoName = file.name;
        };
        reader.readAsDataURL(file);
        openImage(this, "viewImage");
    });

    function openImage(input, imageView) {
        if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function (e) {
                $('#' +imageView).attr('src', reader.result);
            }
            reader.readAsDataURL(input.files[0]);
        }
    }
</script>
</body>
</html>

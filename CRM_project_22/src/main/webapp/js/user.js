$(document).ready(function() {
	$('.btn-xoa').click(function() {
		//$(this) //dai dien cho the dang click 
		var id = $(this).attr("id-user")
		var This = $(this)

		$.ajax({
			method: "GET",
			url: "http://localhost:8080/crm_project_22/api/user/delete?id=" + id,
			//data: { name: "John", location: "Boston" }
		})
			.done(function(result) {
				if (result.data==true) {
					This.closest('tr').remove();
				}
			});
				
	})


})
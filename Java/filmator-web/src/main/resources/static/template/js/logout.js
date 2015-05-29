function logout(){
	$.ajax({
		url: '/template/logout',
		type: 'POST'
	});
}
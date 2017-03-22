$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;

	case 'contact Us':
		$('#contact').addClass('active');
		break;

	case 'All products':
		$('#listProducts').addClass('active');
		break;

	default:
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;

	}

});
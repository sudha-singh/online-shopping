$(function() {

	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
		
	case 'contact Us':
		$('#contact').addClass('active');
		break;

	case 'list product':
		$('#viewproduct').addClass('active');
		break;

	default:
		$('#home').addClass('active');
		break;


	}

});
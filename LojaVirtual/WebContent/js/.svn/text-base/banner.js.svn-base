var how_many_ads = 2;
var now = new Date();
var sec = now.getSeconds();
var ad = sec % how_many_ads;
ad += 1;
if (ad == 1) {
	txt = "";
	url = "";
	alt = "";
	banner = "img/banner1.jpg";
	width = "900";
	height = "190";
}
if (ad == 2) {
	txt = "";
	url = "";
	alt = "";
	banner = "img/banner2.jpg";
	width = "900";
	height = "190";
}
document.write('<center>');
document.write('<a href=\"' + url + '\" target=\"_parent\">');
document.write('<img src=\"' + banner + '\" width=');
document.write(width + ' height=' + height + ' ');
document.write('alt=\"' + alt + '\" border=0><br>');
document.write('<small>' + txt + '</small></a>');
document.write('</center>');

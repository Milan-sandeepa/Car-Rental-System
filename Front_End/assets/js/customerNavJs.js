$(document).on('click','#sidebar li',function () {
    $(this).addClass('active').siblings().removeClass('active')
});

$("#booking-section").css("display", "none");
$("#profile-section").css("display", "none");


$("#homeBtn").click(function () {
    $("#dashboard-section").css("display", "block");
    $("#booking-section").css("display", "none");
    $("#profile-section").css("display", "none");
});

$("#bookingBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "block");
    $("#profile-section").css("display", "none");
});

$("#settingBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#profile-section").css("display", "block");
    $("#booking-section").css("display", "none");
});

$("#settingIcon").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#profile-section").css("display", "block");
    $("#booking-section").css("display", "none");
});
$(document).on('click','#sidebar li',function () {
    $(this).addClass('active').siblings().removeClass('active')
});

$("#booking-section").css("display", "none");
$("#income-section").css("display", "none");
$("#Request-section").css("display", "none");
$("#car-section").css("display", "none");
$("#customer-section").css("display", "none");
$("#driver-section").css("display", "none");

$("#homeBtn").click(function () {
    $("#dashboard-section").css("display", "block");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
    $("#Request-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
});

$("#requestBtn").click(function () {
    $("#Request-section").css("display", "block");
    $("#car-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
});

$("#carBtn").click(function () {
    $("#car-section").css("display", "block");
    $("#Request-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
});
$("#customerBtn").click(function () {
    $("#customer-section").css("display", "block");
    $("#car-section").css("display", "none");
    $("#Request-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
    $("#driver-section").css("display", "none");
});

$("#driverBtn").click(function () {
    $("#driver-section").css("display", "block");
    $("#customer-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#Request-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
});

$("#bookingBtn").click(function () {
    $("#booking-section").css("display", "block");
    $("#driver-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#Request-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#income-section").css("display", "none");
});

$("#notificationBell").click(function () {
    $("#Request-section").css("display", "block");
    $("#car-section").css("display", "none");
    $("#dashboard-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
});
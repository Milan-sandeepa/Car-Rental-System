$(document).on('click','#sidebar li',function () {
    $(this).addClass('active').siblings().removeClass('active')
});

$("#car-section").css("display", "none");
$("#customer-section").css("display", "none");
$("#driver-section").css("display", "none");
$("#booking-section").css("display", "none");
$("#income-section").css("display", "none");

$("#homeBtn").click(function () {
    $("#dashboard-section").css("display", "block");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
});
$("#carBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#car-section").css("display", "block");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
});

$("#customerBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "block");
    $("#driver-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
});

$("#driverBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "block");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "none");
});

$("#bookingBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
    $("#booking-section").css("display", "block");
    $("#income-section").css("display", "none");
});

$("#incomeBtn").click(function () {
    $("#dashboard-section").css("display", "none");
    $("#car-section").css("display", "none");
    $("#customer-section").css("display", "none");
    $("#driver-section").css("display", "none");
    $("#booking-section").css("display", "none");
    $("#income-section").css("display", "block");
});
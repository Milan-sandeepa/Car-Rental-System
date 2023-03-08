let baseUrlCustomer="http://localhost:8080/Car_Rental_System_war/";

getAllCustomers();

//Add User
$("#customerAddBtn").click(function () {

    let formData = new FormData();

    let name = $("#txtUserName").val();
    let gender = $("#txtUserGender").val();
    let address = $("#txtUserAddress").val();
    let contact = $("#txtUserContact").val();
    let email = $("#txtUserEmail").val();
    let nicNo = $("#txtUserNic").val();
    let userPwd = $("#txtUserPwd").val();

    formData.append("name",name);
    formData.append("gender",gender);
    formData.append("address",address);
    formData.append("contact",contact);
    formData.append("email",email);
    formData.append("nicNo",nicNo);
    formData.append("userPwd",userPwd);

    let file1 = $("#file-1")[0].files[0];
    let fileName1 = $("#file-1")[0].files[0].name;

    formData.append("nic/licensePhoto",file1,fileName1);

    $.ajax({
        url: baseUrlCustomer + "customer",
        method: "post",
        data: formData,
        dataType: "json",
        async: true,
        contentType: false,
        processData: false,
        enctype:"multipart/form-data",
        success: function (res) {
            // invoked if the response status code is in 200 range
            console.log("Success Method Invoked")
            console.log(res);
            alert(res.message);
            getAllReqCustomers();
            getAllCustomers();


        },
        error: function (error) {
            // invokes if status code range is 500 range or 400 range
            console.log("Error Method Invoked");
            console.log(JSON.parse(error.responseText));
            alert(JSON.parse(error.responseText).message);

        }
    });

});

//Get all Customer Function
function getAllCustomers() {
    console.log("success load");
    $("#tblCustomer").empty();

    $.ajax({
        url: baseUrlCustomer+"customer",
        success: function (res) {
            console.log(res)
            for (let c of res.data) {
                let name = c.name;
                let gender = c.gender;
                let address = c.address;
                let contact = c.contact;
                let email = c.email;
                let nicNo = c.nicNo;
                let nic_Photo = c.nic_Photo;
                let status = c.status;

                if (status=="Active"){

                    let row = `<tr>

                        <td class="name">${name}</td>
                        <td>${gender}</td>
                        <td>${address}</td>
                        <td>${contact}</td>
                        <td>${email}</td>
                        <td class="nic">${nicNo}</td>
                        <td><img src="${baseUrlCustomer + nic_Photo}" width="50px"></td>

                        <td>
<!--                        <i class="editIconCustomer fa-solid fa-pen-to-square" data-bs-toggle="modal"data-bs-target="#customerEditModal"></i>-->
                        <i class="deleteIconCustomer fa-solid fa-trash" style="margin-left: 10px"></i>
                        </td>

                        </tr>`;

                    $("#tblCustomer").append(row);

                }

            }
            bindRowClickEvents();
            // setTextFieldValues("", "", "", "");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

function bindRowClickEvents() {
    $(".editIconCustomer").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var searchID = row.find(".nic").text();


        if (searchID!=null){
            $.ajax({
                url: baseUrlCustomer+"customer",
                success: function (res) {
                    for (let c of res.data) {
                        console.log(c)
                        if (c.nicNo == searchID) {
                            $('#txtUpdateUserName').val(c.name);
                            $('#txtUpdateUserGender').val(c.gender);
                            $('#txtUpdateUserAddress').val(c.address);
                            $('#txtUpdateUserContact').val(c.contact);
                            $('#txtUpdateUserEmail').val(c.email);
                            $('#txtUpdateUserNic').val(c.nicNo);
                            // $('#txtUpdateUserPwd').val(c.userPwd);
                            // $('#txtUpdateUserConPwd').val(c.userPwd);
                        }
                    }
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });



        }else {
            alert("No such customer to edit. please try Again");
        }

        var searchName = row.find(".name").text();
        if (searchID!=null){
            $.ajax({
                url: baseUrl+"user",
                success: function (res) {
                    for (let c of res.data) {
                        if (c.username == searchName) {

                            $('#txtUpdateUserPwd').val(c.password);
                        }
                    }
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });



        }else {
            alert("No such customer to edit. please try Again");
        }

    });

    $(".deleteIconCustomer").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var id = row.find(".nic").text();

        let option = confirm("Do you really want to delete Customer Nic :" + id);

        if (option){
            $.ajax({
                url: baseUrlCustomer+"customer?id=" + id,
                method: "delete",
                success: function (resp) {
                    getAllCustomers();
                    alert(resp.message);
                },
                error: function (error) {
                    let message = JSON.parse(error.responseText).message;
                    alert(message);
                }
            });
        }
    });
}

$("#customerUpdateBtn").click(function () {
    let res = confirm("Do you want to add this Update Customer.?");
    if (res) {

        let name =$('#txtUpdateUserName').val();
        let gender =$('#txtUpdateUserGender').val();
        let address =$('#txtUpdateUserAddress').val();
        let contact =$('#txtUpdateUserContact').val();
        let email =$('#txtUpdateUserEmail').val();
        let nic_licenseNo =$('#txtUpdateUserNic').val();
        let userPwd =$('#txtUpdateUserPwd').val();


        var customerOb = {
            name: name,
            gender: gender,
            address: address,
            contact: contact,
            email: email,
            nicNo: nic_licenseNo,
            userPwd: userPwd,
        }

        $.ajax({
            url: baseUrlCustomer+"customer",
            method: "put",
            contentType: "application/json",
            data: JSON.stringify(customerOb),
            dataType: "json",
            success: function (resp) {
                getAllCustomers();
                alert(resp.message);
            },
            error: function (error) {
                let message = JSON.parse(error.responseText).message;
                alert(message);
            }
        });

    }else {
        alert("Update Failed..!");
    }
});


// customer search bar
$(document).ready(function (){
    $("#searchCustomerInput").on('keyup',function (){
        var value = $(this).val().toLowerCase();

        $("#tblCustomer>tr").filter(function (){
            $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
        });
    });
});
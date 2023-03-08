let baseUrlReqCustomer="http://localhost:8080/Car_Rental_System_war/";
let content = '';
getAllReqCustomers();

function getAllReqCustomers() {
    console.log("success load");
    $("#tblReq").empty();

    $.ajax({
        url: baseUrlReqCustomer+"customer",
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


                if (status=="Not Active"){

                    let row = `<tr>

                        <td class="name">${name}</td>
                        <td>${gender}</td>
                        <td>${address}</td>
                        <td>${contact}</td>
                        <td>${email}</td>
                        <td class="nic">${nicNo}</td>
                        <td><img src="${baseUrlCustomer + nic_Photo}" width="50px"></td>
                        <td>${status}</td>
                        <td><i class="editIconRequestCustomer fa-solid fa-pen-to-square" data-bs-toggle="modal"data-bs-target="#ReqcustomerEditModal"></i>
                        </td>
        
                        </tr>`;

                    $("#tblReq").append(row);

                }
            }
            bindRowClickEventsReq();
            // setTextFieldValues("", "", "", "");
        },
        error: function (error) {
            let message = JSON.parse(error.responseText).message;
            alert(message);
        }
    });
}

function bindRowClickEventsReq() {
    $(".editIconRequestCustomer").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var searchID = row.find(".nic").text();

        if (searchID!=null){
            $.ajax({
                url: baseUrlReqCustomer+"customer",
                success: function (res) {
                    for (let c of res.data) {
                        console.log(searchID)
                        if (c.nicNo == searchID) {
                            $('#txtReqUserName').val(c.name);
                            $('#txtReqUserAddress').val(c.address);
                            $('#txtReqUserContact').val(c.contact);
                            $('#txtReqUserEmail').val(c.email);
                            $('#txtReqUserNic').val(c.nicNo);
                            $('#txtReqUserStatus').val(c.status);
                            console.log(c.nic_Photo)

                            // content +=`<img src="${baseUrlReqCustomer + c.nic_Photo}" alt="car" style=" width: 415px;height: 261px;margin-right: 2px;margin-bottom: 6px;margin-top: 54px;"> `
                            content=`<img src="${baseUrlReqCustomer + c.nic_Photo}" alt="car" style=" width: 400px;height: 400px;margin-right: 2px;margin-bottom: 6px;"> `

                            document.querySelector("#selectedNicImage").innerHTML = content;

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

    $(".deleteIconRequestCustomer").click(function () {

        // Find the row
        var row = $(this).closest("tr");

        // Find the text
        var id = row.find(".nic").text();

        let option = confirm("Do you really want to delete User Nic :" + id);

        if (option){
            $.ajax({
                url: baseUrlReqCustomer+"customer?id=" + id,
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

$("#customerRequestUpdateBtn").click(function () {
    let res = confirm("Do you want to add this Approve this User.?");
    if (res) {

        let nicNo =$('#txtReqUserNic').val();
        let status =$('#txtReqUserStatus').val();
        let formData = new FormData();

        formData.append("nic/licenseNo",nicNo);
        formData.append("status",status);

        $.ajax({
            url: baseUrlReqCustomer+"customer/status",
            method: "post",
            data: formData,
            dataType: "json",
            async: true,
            contentType: false,
            processData: false,
            success: function (resp) {
                getAllReqCustomers();
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
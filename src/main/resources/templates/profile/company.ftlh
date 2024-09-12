<#import "../layout.ftlh" as main>

<@main.layout ; spring>









    <div class="container my-4">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">
                <div class="card p-4 shadow-sm">
                    <div class="row">
                        <div class="col-12 col-md-4 mb-3 mb-md-0 text-center">
                            <img src="${userDto.avatar!"/static/images/nophoto.jpg"}" alt="Profile Photo" class="img-fluid rounded-circle" style="max-width: 150px;">
                        </div>
                        <div class="col-12 col-md-8">
                            <h5 class="card-title"><@spring.message "profile.company.full_name"/> : ${userDto.name!"Not specified"} ${userDto.surname!"Not specified"}</h5>
                            <p class="card-text"><strong><@spring.message "profile.company.email"/>:</strong> ${userDto.email!"Not specified"}</p>
                            <p class="card-text"><strong><@spring.message "profile.company.phone_number"/>:</strong> ${userDto.phoneNumber!"User Without Phone"}</p>
                            <a href="/vacancies" class="btn btn-outline-info m-2"><@spring.message "profile.company.back_to_vacancies"/></a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



</@main.layout>
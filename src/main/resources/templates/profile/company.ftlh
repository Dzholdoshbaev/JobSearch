<#import "../layout.ftlh" as main>

<@main.layout>









    <div class="container my-4">
        <div class="row justify-content-center">
            <div class="col-12 col-md-8 col-lg-6">
                <div class="card p-4 shadow-sm">
                    <div class="row">
                        <div class="col-12 col-md-4 mb-3 mb-md-0 text-center">
                            <img src="${userDto.avatar!"/static/images/nophoto.jpg"}" alt="Profile Photo" class="img-fluid rounded-circle" style="max-width: 150px;">
                        </div>
                        <div class="col-12 col-md-8">
                            <h5 class="card-title">${userDto.name!"Not specified"} ${userDto.surname!"Not specified"}</h5>
                            <p class="card-text"><strong>Age:</strong> ${userDto.age!"Not specified"}</p>
                            <p class="card-text"><strong>Email:</strong> ${userDto.email!"Not specified"}</p>
                            <p class="card-text"><strong>Phone Number:</strong> ${userDto.phoneNumber!"User Without Phone"}</p>
                            <p class="card-text"><strong>Role:</strong>
                                <#if user?? && user.authorities?seq_contains("APPLICANT")>
                                    APPLICANT
                                <#else>
                                    EMPLOYER
                                </#if>
                            </p>
                            <a href="/vacancies" class="btn btn-outline-info m-2">Back to Vacancies</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>



</@main.layout>
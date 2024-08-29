<#import "../layout.ftlh" as main>

<@main.layout>










    <div class="col col-12 col-md-4 colpost">
        <div class="col col-12 col-md-6 colpost">
            <img src="${userDto.avatar!"/static/images/nophoto.jpg"}" alt="ProfilePhoto"/>
        </div>
        <h5 class="card-title">${userDto.name!"Not specified"}  ${userDto.surname!"Not specified"}</h5>
        <p class="card-text">${userDto.age!"Not specified"}</p>
        <p class="card-text">${userDto.email!"Not specified"}</p>
        <p class="card-text">${userDto.phoneNumber!"User Without Phone"}</p>
        <#if user?? && user.authorities?seq_contains("APPLICANT")>
            <p class="card-text">APPLICANT</p>
        <#else>
            <p class="card-text">EMPLOYER</p>
        </#if>
    </div>




</@main.layout>
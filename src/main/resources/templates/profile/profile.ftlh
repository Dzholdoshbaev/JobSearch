<#import "../layout.ftlh" as main>

<@main.layout>


    <div class="card" style="width: 18rem;">
        <img src="/static/images/nophoto.jpg" class="card-img-top" alt="UserPhoto">
        <div class="card-body">
            <h5 class="card-title">${user.name}  ${user.surname}</h5>
            <p class="card-text">${user.age}</p>
            <p class="card-text">${user.email}</p>
            <p class="card-text">${user.phoneNumber}</p>
            <a href="profile/edit" class="btn btn-primary">Edit profile</a>
        </div>
    </div>

</@main.layout>
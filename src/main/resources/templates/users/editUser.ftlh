<#import "../layout.ftlh" as main>

<@main.layout ; spring>




    <form action="/profile/edit" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title"><@spring.message "users.editUser.name"/></span>
            <@spring.formInput "userDtoEdit.name" 'class="form-control" aria-label="Name" aria-describedby="name" name="name"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year"><@spring.message "users.editUser.surname"/></span>
            <@spring.formInput "userDtoEdit.surname" 'class="form-control" aria-label="Surname" aria-describedby="surname" name="surname"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year"><@spring.message "users.editUser.age"/></span>
            <@spring.formInput "userDtoEdit.age" 'class="form-control" aria-label="Age" aria-describedby="age" name="age"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year"><@spring.message "users.editUser.email"/></span>
            <@spring.formInput "userDtoEdit.email" 'class="form-control" aria-label="Email" aria-describedby="email" name="email"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year"><@spring.message "users.editUser.password"/></span>
            <@spring.formInput "userDtoEdit.password" 'class="form-control" aria-label="Password" aria-describedby="password" name="password"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year"><@spring.message "users.editUser.phone_number"/></span>
            <@spring.formInput "userDtoEdit.phoneNumber" 'class="form-control" aria-label="PhoneNumber" aria-describedby="phoneNumber" name="phoneNumber"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <button type="submit" class="btn btn-outline-info m-2"><@spring.message "users.editUser.submit"/></button>
    </form>

</@main.layout>
<#import "../layout.ftlh" as main>

<@main.layout ; spring>





    <form action="/profile/register" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Name</span>
            <@spring.formInput "usersDto.name" 'class="form-control" aria-label="Name" aria-describedby="name" name="name"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Surname</span>
            <@spring.formInput "usersDto.surname" 'class="form-control" aria-label="Surname" aria-describedby="surname" name="surname"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Age</span>
            <@spring.formInput "usersDto.age" 'class="form-control" aria-label="Age" aria-describedby="age" name="age"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Email</span>
            <@spring.formInput "usersDto.email" 'class="form-control" aria-label="Email" aria-describedby="email" name="email"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Password</span>
            <@spring.formInput "usersDto.password" 'class="form-control" aria-label="Password" aria-describedby="password" name="password"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Phone Number</span>
            <@spring.formInput "usersDto.phoneNumber" 'class="form-control" aria-label="PhoneNumber" aria-describedby="phoneNumber" name="phoneNumber"' />
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="authorityId">Account Type</span>
            <select class="form-select" aria-label="authorityId" aria-describedby="authorityId" name="authorityId">
                <option value="" disabled selected>Select an option</option>
                <#list authoritiesUser as item>
                    <option value="${item.id}">${item.authority}</option>
                </#list>
            </select>
            <div class="text-danger" ><@spring.showErrors  "<br>" "error"/></div>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>



</@main.layout>
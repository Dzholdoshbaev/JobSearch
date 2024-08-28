<#import "../layout.ftlh" as main>

<@main.layout ; spring>





    <form action="/profile/register" method="post">

        <#if _csrf??>
            <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                   value="${(_csrf.token)!'csrf-token'}"/>
        </#if>

        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Name</span>
            <input type="text" class="form-control" aria-label="Name" aria-describedby="title" name="name">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Surname</span>
            <input type="text" class="form-control" aria-label="Surname" aria-describedby="year" name="surname">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Age</span>
            <input type="number" class="form-control" aria-label="Age" aria-describedby="age" name="age">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Email</span>
            <@spring.formInput "usersDto.email" 'class="form-control" aria-label="Email" aria-describedby="email" name="email"' />
<#--            <input type="text" class="form-control" aria-label="Email" aria-describedby="email" name="email">-->
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Password</span>
            <@spring.formInput "usersDto.password" 'class="form-control" aria-label="Password" aria-describedby="password" name="password"' />
<#--            <input type="text" class="form-control" aria-label="Password" aria-describedby="password" name="password">-->
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Phone Number</span>
            <input type="text" class="form-control" aria-label="Phone Number" aria-describedby="phone_number" name="phoneNumber">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="authorities">Account type</span>
            <select class="form-select" aria-label="authorities" aria-describedby="authorities" name="authorities">
                <option selected>Open this select menu</option>
                <#list authoritiesUser as item>
                    <option value="${item.id}">${item.authority}</option>
                </#list>
            </select>
        </div>
        <@spring.showErrors "<br> " "error text-danger" />
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>



</@main.layout>
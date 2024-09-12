<#import "../layout.ftlh" as main>

<@main.layout ; spring>
    <div class="container mt-5">
        <h2 class="mb-4"><@spring.message "profile.register.register"/></h2>
        <form action="/profile/register" method="post">
            <#if _csrf??>
                <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                       value="${(_csrf.token)!'csrf-token'}"/>
            </#if>
            <table class="table table-bordered">
                <tbody>
                <tr>
                    <th scope="row"><@spring.message "profile.register.name"/></th>
                    <td>
                        <@spring.formInput "usersDto.name" 'class="form-control" aria-label="Name" aria-describedby="name" name="name"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.surname"/></th>
                    <td>
                        <@spring.formInput "usersDto.surname" 'class="form-control" aria-label="Surname" aria-describedby="surname" name="surname"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.age"/></th>
                    <td>
                        <@spring.formInput "usersDto.age" 'class="form-control" aria-label="Age" aria-describedby="age" name="age"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.email"/></th>
                    <td>
                        <@spring.formInput "usersDto.email" 'class="form-control" aria-label="Email" aria-describedby="email" name="email"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.password"/></th>
                    <td>
                        <@spring.formInput "usersDto.password" 'class="form-control" aria-label="Password" aria-describedby="password" name="password"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.phone_number"/></th>
                    <td>
                        <@spring.formInput "usersDto.phoneNumber" 'class="form-control" aria-label="PhoneNumber" aria-describedby="phoneNumber" name="phoneNumber"' />
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                <tr>
                    <th scope="row"><@spring.message "profile.register.account_type"/></th>
                    <td>
                        <select class="form-select" aria-label="authorityId" aria-describedby="authorityId" name="authorityId">
                            <option value="" disabled selected><@spring.message "profile.register.select_an_option"/></option>
                            <#list authoritiesUser as item>
                                <option value="${item.id}">${item.authority}</option>
                            </#list>
                        </select>
                        <div class="text-danger"><@spring.showErrors "<br>" "error"/></div>
                    </td>
                </tr>
                </tbody>
            </table>
            <button type="submit"  class="btn btn-outline-info m-2"><@spring.message "profile.register.submit"/></button>
        </form>
    </div>
</@main.layout>
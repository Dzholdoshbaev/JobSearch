<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <h5 class="card-title">${resetPasswordToken!""}</h5>
    <div class="py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="/reset/token/${user.id}" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>
                    <div class="form-outline border border-secondary rounded p-3">
                        <p><@spring.message "auth.reset_password_form.enter_token"/></p>
                        <#if errorMessage??>
                            <div class="alert alert-danger" role="alert">
                                ${errorMessage}
                            </div>
                        </#if>
                        <p>
                            <input type="text" name="token" class="form-control" required autofocus/>
                        </p>
                        <p class="text-center">
                            <button type="submit" class="btn btn-primary"><@spring.message "auth.reset_password_form.send"/></button>
                        </p>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@main.layout>

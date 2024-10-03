<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <h2><@spring.message "auth.forgot_password_form.forgot_password"/></h2>
    <div class="py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="/reset" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>
                    <div class="form-outline border border-secondary rounded p-3">
                        <p><@spring.message "auth.forgot_password_form.we_will_be_sending_a_reset_password_link_to_your_email."/></p>
                        <div>
                            <p><@spring.message "auth.forgot_password_form.enter_your_e-mail"/></p>
                            <#if errorMessage??>
                                <div class="alert alert-danger" role="alert">
                                    ${errorMessage}
                                </div>
                            </#if>
                            <p>
                                <input type="email" name="email" class="form-control" required autofocus/>
                            </p>
                            <p class="text-center">
                                <button type="submit" class="btn btn-primary"><@spring.message "auth.forgot_password_form.send"/></button>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@main.layout>

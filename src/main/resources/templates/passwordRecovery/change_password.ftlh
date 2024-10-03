<#import "../layout.ftlh" as main>
<@main.layout ; spring>
    <h2><@spring.message "auth.reset_password_form.reset_your_password"/></h2>
    <p><@spring.message "auth.reset_password_form.password_should_contain_at_least_one_uppercase_letter,_one_number,_and_its_length_must_be_between_4_and_20_characters."/></p>
    <p><@spring.message "auth.reset_password_form.make_sure_you_write_correct_!"/></p>
    <div class="py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
                <form action="/reset/password/${userId}" method="post">
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>
                    <div class="form-outline border border-secondary rounded p-3">
                        <div>
                            <p><@spring.message "passwordRecovery.change_password.add_password"/></p>
                            <#if errorMessage??>
                                <div class="alert alert-danger" role="alert">
                                    ${errorMessage}
                                </div>
                            </#if>
                            <p>
                                <input type="password" name="password" class="form-control" required autofocus/>
                            </p>
                            <p class="text-center">
                                <button type="submit" class="btn btn-primary"><@spring.message "auth.reset_password_form.send"/></button>
                            </p>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</@main.layout>

<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="text-center">
        <h2><@spring.message "auth.reset_password_form.reset_your_password"/></h2>
        <p><@spring.message "auth.reset_password_form.password_should_contain_at_least_one_uppercase_letter,_one_number,_and_its_length_must_be_between_4_and_20_characters."/></p>
        <p><@spring.message "auth.reset_password_form.make_sure_you_write_correct_!"/></p>
        <#if error??>
            <b class="text-danger">${error}</b>
        </#if>
    </div>

    <div class="py-5 h-100">
        <div class="row d-flex align-items-center justify-content-center h-100">
            <div class="col-md-7 col-lg-5 col-xl-5">
                <form action="/auth/reset_password" method="post">
                    <!-- CSRF -->
                    <#if _csrf??>
                        <input type="hidden" name="${(_csrf.parameterName)!'csrf-param-name'}"
                               value="${(_csrf.token)!'csrf-token'}"/>
                    </#if>

                    <p><@spring.message "auth.reset_password_form.enter_your_new_password"/></p>
                    <!-- PASSWORD -->
                    <input type="hidden" name="token" value="${token!}">
                    <input type="password" name="password" class="form-control"
                            required autofocus/>
                    <p class="text-center">
                        <button type="submit" class="btn btn-primary mt-3"><@spring.message "auth.reset_password_form.change_password"/></button>
                    </p>
                </form>
            </div>
        </div>
    </div>

</@main.layout>
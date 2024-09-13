<#import "../layout.ftlh" as main>
<@main.layout ; spring>

    <div class="text-center">
        <h2><@spring.message "auth.message.reset_your_password!"/></h2>
        <p class="text-warning">${message}</p>
    </div>

</@main.layout>
<#import "../layout.ftlh" as main>

<@main.layout>




    <form action="/users/create" method="post">
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
            <input type="text" class="form-control" aria-label="Email" aria-describedby="email" name="email">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Password</span>
            <input type="text" class="form-control" aria-label="Password" aria-describedby="password" name="password">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="year">Phone Number</span>
            <input type="text" class="form-control" aria-label="Phone Number" aria-describedby="phone_number" name="phone_number">
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="director">Account type</span>
            <select class="form-select" aria-label="Director" aria-describedby="director" name="directorId">
                <option selected>Open this select menu</option>
                <#list authorities as item>
                    <option value="${item.id}">${item.authority}</option>
                </#list>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>




</@main.layout>
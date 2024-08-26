<#import "../layout.ftlh" as main>

<@main.layout ; spring>

    <form action="/vacancies/create" method="post">
        <div class="input-group mb-3">
            <span class="input-group-text" id="title">Name</span>
            <input type="text" class="form-control" aria-label="Name" aria-describedby="title" name="name" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="description">Description</span>
            <input type="text" class="form-control" aria-label="Description" aria-describedby="description" name="description" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="categories">Category ID</span>
            <select class="form-select" aria-label="categories" aria-describedby="categories" name="categories">
                <option selected>Open this select menu</option>
                <#list categoriesDto as item>
                    <option value="${item.id}">${item.name}</option>
                </#list>
            </select>
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="salary">Salary</span>
            <input type="number" class="form-control" aria-label="Salary" aria-describedby="salary" name="salary" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expFrom">Experience From</span>
            <input type="number" class="form-control" aria-label="Experience From" aria-describedby="expFrom" name="expFrom" />
        </div>
        <div class="input-group mb-3">
            <span class="input-group-text" id="expTo">Experience To</span>
            <input type="number" class="form-control" aria-label="Experience To" aria-describedby="expTo" name="expTo" />
        </div>
        <div class="form-check mb-3">
            <input class="form-check-input" type="checkbox" id="isActive" name="isActive">
            <label class="form-check-label" for="isActive">
                Active
            </label>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>

    </form>

</@main.layout>

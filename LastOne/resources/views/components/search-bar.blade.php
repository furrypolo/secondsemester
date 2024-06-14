<div class="card">
    <div class="card-header pb-0 border-0">
        <h5 class="">Search</h5>
    </div>
    <div class="card-body">
        <form action="{{route('dashboard')}}" method="GET">
            <input name="search" placeholder="what are you looking for?" class="form-control w-100" type="text" id="search">
            <button class="searchbtn">Search</button>
        </form>
    </div>
</div>
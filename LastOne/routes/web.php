<?php

use App\Http\Controllers\ProfileController;
use App\Http\Middleware\PreventBackHistory;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\HomeController;
use App\Http\Controllers\AdminController;
use App\Http\Controllers\SellerController;
use App\Http\Controllers\ProductController;

Route::get('/', [HomeController::class, 'home'])->name('home');

Route::get('/dashboard', function () {
    return view('home.index');
})->middleware(['auth', 'verified'])->name('dashboard');

Route::middleware('auth')->group(function () {
    Route::get('/profile', [ProfileController::class, 'edit'])->name('profile.edit');
    Route::patch('/profile', [ProfileController::class, 'update'])->name('profile.update');
    Route::delete('/profile', [ProfileController::class, 'destroy'])->name('profile.destroy');
});

Route::get('/product', [ProductController::class, 'showProduct'])->name('product.show');

Route::middleware(['auth', PreventBackHistory::class])->group(function () {
    Route::get('/register-seller', [SellerController::class, 'create'])->name('create.seller');
    Route::post('/register-seller', [SellerController::class, 'registerSeller'])->name('register.seller');
});

Route::get('seller/dashboard/{shop_name}', [SellerController::class, 'add_product'])->name('create.seller_dashboard');
Route::get('add_product', [SellerController::class, 'add_product'])->name('add.product');
Route::post('add_product', [SellerController::class, ''])->middleware(['auth', 'seller']);

require __DIR__.'/auth.php';

Route::get('admin/dashboard', [HomeController::class, 'index'])->middleware(['auth', 'admin', PreventBackHistory::class]);
Route::get('view_category', [AdminController::class, 'view_category'])->middleware(['auth', 'admin', PreventBackHistory::class]);
Route::post('add_category', [AdminController::class, 'add_category'])->middleware(['auth', 'admin', PreventBackHistory::class]);
Route::get('delete_category/{id}', [AdminController::class, 'delete_category'])->middleware(['auth', 'admin', PreventBackHistory::class]);
Route::get('edit_category/{id}', [AdminController::class, 'edit_category'])->middleware(['auth', 'admin', PreventBackHistory::class]);
Route::post('update_category/{id}', [AdminController::class, 'update_category'])->middleware(['auth', 'admin', PreventBackHistory::class]);
<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Models\Category;
use Illuminate\View\View;
use App\Models\Shop;

class SellerController extends Controller
{

    public function create(): View
    {
        return view('seller.register');
    }

    public function registerSeller(Request $request)
    {
        $request->validate([
            'name' => ['required', 'string', 'max:255'],
        ]);

        $shops = Shop::create([
            'shop_name' => $request->name,
            'seller_id' => Auth::user()->id,
        ]);

        $user = Auth::user();
        $user->usertype = 'seller';
        $user->save();

        return redirect()->route('home');
    }

    public function add_product($shop_name)
    {
        return view('seller.index', compact('shop_name'));
    }

    public function store_product(Request $request)
    {

    }
}

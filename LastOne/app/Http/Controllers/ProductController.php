<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ProductController extends Controller
{
    public function showProduct()
    {
        return view('product');
    }

    public function searching(Request $searched)
    {
        if(request()->has('search')){
            $search = $searched->search;

            $posts = Post::where(function($query) use ($search){
                $query->where('title', 'like', "%$search%")->orWhere('description', 'like', "%$search%");
            })
            ->orWhereHas('category', function($query) use($search){
                $query->where('name', 'like', "%$search%");
            })
            ->get();
        }
        return view('product', compact('posts', 'search'));
    }
}
?>

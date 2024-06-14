<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class UserController extends Controller
{
    public function searchField(Request $request){
        $incomingFields = $request->validate([
            'searched' => 'required'
        ]);
        $user = User::create($incomingFields);
        auth()->login($user);
        return redirect('/');
    }
}

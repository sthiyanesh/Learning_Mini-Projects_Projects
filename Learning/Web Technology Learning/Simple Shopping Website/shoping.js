var cartitems = [];
var cart = document.getElementById('cart');
if (window.location.href.indexOf('?fromback=') > 0) {
    if (typeof(Storage) !== "undefined") {
        cartitems = JSON.parse(localStorage.getItem("cartitems"));
        console.log(cartitems);
    } else {
        console.log("Browser does not support Web Storage.");
    }
}
cart.onclick = function(){
    if (typeof(Storage) !== "undefined"){
        localStorage.setItem("cartitems", JSON.stringify(cartitems));
        location.href="index2.html";
    }
}
var shirt = document.getElementById('shirt');
shirt.onclick = function() {
    var size = document.getElementById('1sizes').value;
    var color = document.getElementById('1colors').value;
    var Quantity = parseInt(document.getElementById('1Quan').value);
    var price = 1999; 
    if(Quantity > 0 && Quantity <= 100){
        var flag = 0;
        for(var i=0;i<cartitems.length;i++){
            if(cartitems[i][1]=="Raymond Shirt, Size:"+size+", Color:"+color){
                flag=1;
                cartitems[i][2] += Quantity;
                cartitems[i][5] += cartitems[i][4]*Quantity;
                break;

            }
        }
        if(flag==0){
        var temp = [];
        var disprice = price-(price*5/100);
        var TotalPrice = disprice*Quantity;
        temp.push(cartitems.length+1,"Raymond Shirt, Size:"+size+", Color:"+color,Quantity,price,disprice,TotalPrice);
        cartitems.push(temp);
        }
        alert("Added to cart successfully.");
        console.log(cartitems);
    }else{
        alert("Quantity must be between 1 and 100");
    }
}
var tshirt = document.getElementById('tshirt');
tshirt.onclick = function() {
    var size = document.getElementById('2sizes').value;
    var color = document.getElementById('2colors').value;
    var Quantity = parseInt(document.getElementById('2Quan').value);
    var price = 999; 
    if(Quantity > 0 && Quantity <= 100){
        var flag = 0;
        for(var i=0;i<cartitems.length;i++){
            if(cartitems[i][1]=="Raymond TShirt, Size:"+size+", Color:"+color){
                flag=1;
                cartitems[i][2] += Quantity;
                cartitems[i][5] += cartitems[i][4]*Quantity;
                break;
            }
        }
        if(flag==0){
        var temp = [];
        var disprice = price-(price*5/100);
        var TotalPrice = disprice*Quantity;
        temp.push(cartitems.length+1,"Raymond TShirt, Size:"+size+", Color:"+color,Quantity,price,disprice,TotalPrice);
        cartitems.push(temp);
        }
        alert("Added to Cart successfully.");
        console.log(cartitems);
    }else{
        alert("Quantity must be between 1 and 100");
    }
}
var pant = document.getElementById('pant');
pant.onclick = function() {
    var size = document.getElementById('3sizes').value;
    var color = document.getElementById('3colors').value;
    var Quantity = parseInt(document.getElementById('3Quan').value);
    var price = 1499; 
    if(Quantity > 0 && Quantity <= 100){
        var flag = 0;
        for(var i=0;i<cartitems.length;i++){
            if(cartitems[i][1]=="Raymond Pant, Size:"+size+", Color:"+color){
                flag=1;
                cartitems[i][2] += Quantity;
                cartitems[i][5] += cartitems[i][4]*Quantity;
                break;
            }
        }
        if(flag==0){
        var temp = [];
        var disprice = price-(price*5/100);
        var TotalPrice = disprice*Quantity;
        temp.push(cartitems.length+1,"Raymond Pant, Size:"+size+", Color:"+color,Quantity,price,disprice,TotalPrice);
        cartitems.push(temp);
        }
        alert("Added to Cart successfully.");
        console.log(cartitems);
    }else{
        alert("Quantity must be between 1 and 100");
    }
}
var cartitems = [];
if (typeof(Storage) !== "undefined") {
    cartitems = JSON.parse(localStorage.getItem("cartitems"));
} else {
    console.log("Browser does not support Web Storage.");
}
var tabling = document.getElementById('tabular');
var tabular = [];
var sum = 0;
tabular.push('<table style="width:75%"><tr><th>S.No</th><th>Product Detail</th><th>Quantity</th><th>Price</th><th>Discounted Price</th><th>Final Price</th></tr>');
for(var i=0;i<cartitems.length;i++){
    sum = sum + cartitems[i][5];
    tabular.push('<tr><td>'+cartitems[i][0]+'</td><td>'+cartitems[i][1]+'</td><td>'+cartitems[i][2]+'</td><td>'+cartitems[i][3]+'</td><td>'+cartitems[i][4]+'</td><td>'+cartitems[i][5]+'</td></tr>');
}
tabular.push('</table>');
tabular.push('<p style="text-align: right;width:76%">Total Price = Rs.'+sum+' /-</p>');
tabling.innerHTML = tabular.join('');
console.log(sum);
var back = document.getElementById('back');
back.onclick = function() {
    if (typeof(Storage) !== "undefined"){
        localStorage.setItem("cartitems", JSON.stringify(cartitems));
        location.href="index1.html?fromback=on";
    }
}
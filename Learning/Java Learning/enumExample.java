enum Restaurants {
    dominos, kfc, pizzahut, paninos, burgerking
}
class enumExample {
    public static void main(String args[]){
        Restaurants r = Restaurants.paninos;
        switch(r) { 
        case dominos: 
            System.out.println("I AM " + r.dominos);
            break;
        case kfc:
            System.out.println("I AM " + r.kfc);
            break;
        case pizzahut:
            System.out.println("I AM " + r.pizzahut);
            break;
        case paninos:
            System.out.println("I AM " + r.paninos);
            break;
        case burgerking:
            System.out.println("I AM " + r.burgerking);
            break;
        }
    }
}
package ie.atu.lambda;

class ToUpperCase implements StringOperation {
    @Override
    public String apply(String str) {
        return str.toUpperCase();
    }
}

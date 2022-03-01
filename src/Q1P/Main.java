package Q1P;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Predicate;

public class Main {

    private static List<Product> filterProductByCategory(List<Product> products, Predicate<Product> predicate) {
        List<Product> productList = new ArrayList<>();
        for (Product product : products) {
            if (predicate.test(product))
                productList.add(product);
        }
        return productList;
    }

    public static void main(String[] args) {
        Category electronic = new Category(1, "electronic", null);
        Category mobile = new Category(2, "mobile", electronic);
        Category laptop = new Category(3, "laptop", electronic);

        Product iphone13 = new Product(1, "iphone 13", 24000000, 50, mobile);
        Product iphone13ProMax = new Product(2, "iphone 13 pro max", 38000000, 50, mobile);
        Product samsungS21 = new Product(3, "samsung s21", 32000000, 50, mobile);

        Product lenovoIP700 = new Product(4, "lenovo ideapad 700", 32000000, 50, laptop);
        Product surface6 = new Product(5, "microsoft surface 6", 42000000, 50, laptop);
        Product macbook2019 = new Product(6, "apple macbook 2019", 46000000, 50, laptop);

        List<Product> products = new ArrayList<>();
        products.add(iphone13);
        products.add(iphone13ProMax);
        products.add(samsungS21);
        products.add(lenovoIP700);
        products.add(surface6);
        products.add(macbook2019);

        System.out.println("**************** Part 1 ****************");
        List<Product> productList = filterProductByCategory(products, product -> product.getCategory().equals(laptop));
        for (Product product : productList) {
            System.out.println(product);
        }

        Customer customer1 = new Customer(1, "hassan", "mohseni");
        Customer customer2 = new Customer(2, "mehdi", "karimi");

        Product[] productList1 = new Product[]{lenovoIP700, iphone13};
        Order order1 = new Order(1, productList1, customer1, (productList1[0].getPrice() + productList1[1].getPrice())
                , Date.valueOf("2021-02-01"), false);

        Product[] productList2 = new Product[]{lenovoIP700, samsungS21};
        Order order2 = new Order(1, productList2, customer1, (productList2[0].getPrice() + productList2[1].getPrice())
                , Date.valueOf("2021-03-01"), false);

        Product[] productList3 = new Product[]{lenovoIP700, surface6};
        Order order3 = new Order(1, productList3, customer1, (productList3[0].getPrice() + productList3[1].getPrice())
                , Date.valueOf("2021-03-15"), false);

        Product[] productList4 = new Product[]{lenovoIP700, surface6};
        Order order4 = new Order(1, productList4, customer1, (productList4[0].getPrice() + productList4[1].getPrice())
                , Date.valueOf("2021-05-13"), false);

        Product[] productList5 = new Product[]{lenovoIP700, surface6};
        Order order5 = new Order(1, productList5, customer1, (productList5[0].getPrice() + productList5[1].getPrice())
                , Date.valueOf("2021-05-20"), false);

        List<Order> orders = new ArrayList<>();
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        System.out.println("**************** Part 2 ****************");
        orders.stream().filter(order -> order.getDate().after(Date.valueOf("2021-01-30")) &&
                        order.getDate().before(Date.valueOf("2021-04-1")))
                .forEach(System.out::println);

        System.out.println("**************** Part 3 ****************");
        products.stream()
                .filter(product -> product.getCategory().equals(mobile))
                .sorted(Comparator.comparingInt(Product::getPrice))
                .limit(1)
                .forEach(System.out::println);
        System.out.println("**************** Part 4 ****************");
        AtomicReference<Integer> a = new AtomicReference<>(0);
        AtomicReference<Integer> counter = new AtomicReference<>(0);
        orders.stream().filter(order -> order.getDate().after(Date.valueOf("2021-01-30")) &&
                        order.getDate().before(Date.valueOf("2021-04-1")))
                .mapToInt(Order::getBill)
                .forEach(aNumber -> {
                    a.updateAndGet(v -> v + aNumber);
                    counter.getAndSet(counter.get() + 1);
                });
        System.out.println("average: " + a.get() / counter.get());

    }
}
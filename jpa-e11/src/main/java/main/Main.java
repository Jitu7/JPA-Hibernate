package main;

import entities.Product;

import javax.persistence.Persistence;

public class Main {
    /*
    persist()
    flush()

    find()
    getReference()
    contains()

    remove() --> want to remove it from Persistence level

    detach() --> used to take something out of the context
    clear() --> used to take something out of the context

    merge()
    refresh()

    persist(), flush(), detach(), merge(), refresh() all this op can be cascaded.
    By default they are not.

     */

    public static void main(String[] args) {
        var emf = Persistence.createEntityManagerFactory("my-persistence-unit");
        var em = emf.createEntityManager();

        em.getTransaction().begin();

//        Product p = new Product();
//        p.setId(10);
//        p.setName("P1");
//
//        em.persist(p); // INSERT
//        em.flush(); // forcing the implementation to send the changes of the context
//                    // and persist in the db before commit
//
//        System.out.println(":)");

        /*
        if id does n't exist it returns null
         */
//        Product p = em.find(Product.class, 10); // take from db and put in the context
//        System.out.println(p);

        /*
            Difference between find() and getReference() ?
            find() -> Eager loading
            getReference() -> Lazy loading

            getReference() only gives us a proxy
            getReference() triggers the select query only when that proxy is used
         */
//        var reference = em.getReference(Product.class, 10); // lazy loading
//        System.out.println(reference); // used

        /*
        tells if the instance is on the context or not
         */
//        var product = em.find(Product.class, 10);
//        System.out.println(em.contains(product)); // true
//
//        var product2 = new Product();
//        product2.setName("Product 2");
//        product2.setId(50);
//
//        em.persist(product2);
//        System.out.println(em.contains(product2)); // true

        // Exception
//        var product3 = new Product();
//        product3.setId(100);
//        em.remove(product3); // only works on managed instances product3 is not in the context

//        var productToRemove = em.find(Product.class, 10);
//        em.remove(productToRemove);

        /*
        merge() does not insert in the database
         */
//        var product = new Product();
//        product.setId(11);
//        em.merge(product); // add in the context the detached instance
//        System.out.println(em.contains(product)); // false
//        em.remove(product);

//        var product = em.find(Product.class, 10);
//        product.setName("Y");
//        em.refresh(product); // updates the instance with what we have in the DB
        // the name of product becomes again Y

        var product = new Product();
        product.setName("Q");
        product.setId(100);
        em.persist(product); // product is added to the context

        em.clear(); // takes all instances out of the context
//        em.detach(product); // takes product out of the context

        em.getTransaction().commit();
        em.close();
    }

}
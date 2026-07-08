package Newproject;

import java.util.Scanner;

public class RetailInvoice {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== RETAIL INVOICE WITH GST =====");

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        String[] name = new String[n];
        double[] price = new double[n];
        int[] qty = new int[n];
        double[] discount = new double[n];
        double[] gst = new double[n];
        double[] total = new double[n];
        double[] net = new double[n];

        double subtotal = 0;

        for (int i = 0; i < n; i++) {

            System.out.println("\nItem " + (i + 1));

            System.out.print("Enter Item Name: ");
            name[i] = sc.next();

            System.out.print("Enter Price: ");
            price[i] = sc.nextDouble();

            System.out.print("Enter Quantity: ");
            qty[i] = sc.nextInt();

            System.out.print("Enter Discount (%): ");
            discount[i] = sc.nextDouble();

            System.out.print("Enter GST (%): ");
            gst[i] = sc.nextDouble();

            total[i] = price[i] * qty[i];

            double disAmt = total[i] * discount[i] / 100;

            net[i] = total[i] - disAmt;

            subtotal += net[i];
        }

        System.out.print("\nEnter Coupon Amount: ");
        double coupon = sc.nextDouble();

        if (coupon > subtotal) {
            coupon = subtotal;
        }

        double taxable = subtotal - coupon;

        double totalGST = 0;

        for (int i = 0; i < n; i++) {

            double share = net[i] / subtotal;
            double taxableItem = taxable * share;

            totalGST += taxableItem * gst[i] / 100;
        }

        double cgst = totalGST / 2;
        double sgst = totalGST / 2;

        double finalAmount = taxable + totalGST;

        long rounded = Math.round(finalAmount);

        double adjustment = rounded - finalAmount;

        System.out.println("\n==========================================");
        System.out.println("              RETAIL INVOICE");
        System.out.println("==========================================");

        for (int i = 0; i < n; i++) {

            System.out.println("\nItem Name : " + name[i]);
            System.out.println("Price     : " + price[i]);
            System.out.println("Quantity  : " + qty[i]);
            System.out.println("Amount    : " + String.format("%.2f", total[i]));
            System.out.println("Discount  : " + discount[i] + "%");
            System.out.println("Net Amount: " + String.format("%.2f", net[i]));
        }

        System.out.println("\n------------------------------------------");

        System.out.println("Subtotal           : " + String.format("%.2f", subtotal));
        System.out.println("Coupon Discount    : " + String.format("%.2f", coupon));
        System.out.println("Taxable Value      : " + String.format("%.2f", taxable));
        System.out.println("Total GST          : " + String.format("%.2f", totalGST));
        System.out.println("CGST               : " + String.format("%.2f", cgst));
        System.out.println("SGST               : " + String.format("%.2f", sgst));
        System.out.println("Final Amount       : " + String.format("%.2f", finalAmount));
        System.out.println("Rounded Payable    : " + rounded);
        System.out.println("Rounding Adjustment: " + String.format("%.2f", adjustment));

        System.out.println("==========================================");

        sc.close();
    }
}
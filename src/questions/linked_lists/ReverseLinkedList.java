package questions.linked_lists;

import annotation.Strategy;
import annotation.SwitchMenu;
import base.DSABase;
import base.ListQuestions;
import data_structures.Node;
import utils.StringUtils;

import java.util.Scanner;

/**
 * Created by tmsbn on 6/7/16.
 */
public class ReverseLinkedList extends ListQuestions implements DSABase {

    Node head, tail;

    @Override
    public void execute() {

        new SwitchMenu(this).show();

    }

    @Strategy
    public void iterativeMethod() {

        constructList();
        printList();

        System.out.println(StringUtils.lineSeparator);
        reverseStringList();
        printList();
    }

    private void reverseStringList() {

        Node temp = head;
        Node next = null, prev = null;

        while (temp != null) {

            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;

        }

        temp = head;
        head = tail;
        tail = temp;
    }

    private void constructList() {

        System.out.println("Enter numbers:");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.isEmpty())
                break;
            else {
                try {
                    int integer = Integer.parseInt(input);
                    Node node = new Node(integer);
                    if (head == null) {
                        head = node;
                        tail = node;
                    } else {
                        tail.next = node;
                        tail = node;
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            }


        }
    }

    private void printList() {

        Node temp = head;
        boolean isFirst = false;
        while (temp != null) {

            if (isFirst) {
                System.out.print(">");

            }

            System.out.print(temp.number);
            temp = temp.next;
            isFirst = true;
        }
    }

}

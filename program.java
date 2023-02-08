/* ДЗ №3
1 Объявить два списка список ArrayList, в каждый добавить по 20 случайных чисел. Удалить из первого списка элементы,
отсутствующие во втором списке. Отсортировать первый список методом sort класса Collections.
2* Отсортировать второй список методом sort списка и компаратором по уменьшению.
3** Отсортировать первый список пузырьковой сортировкой самостоятельно, без использования доп методов и классов.*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class program {
public static void main(String[] args) {
ArrayList<Integer> alist1 = new ArrayList<>();
ArrayList<Integer> alist2 = new ArrayList<>();
System.out.println("Список 1: " + fillAListOfRandom(alist1, 20));
System.out.println("Список 2: " + fillAListOfRandom(alist2, 20));
System.out.printf("Сортированный по возрастанию методом sort класса Collections\n" + // сделал копию списка 1, чтобы его потом можно было ещё раз отсортировать
"список совпадающих элементов списков 1 и 2 ():\n%s\n", SortAList(deleteFromAList(alist1, alist2)));
System.out.printf("Сортированный по убыванию методом sort списка и компаратором список 2:\n%s\n", SortAListComparator(alist2));
System.out.printf("Сортированный по возрастанию пузырьковым методом список 1:\n%s\n", SortAListBubble(alist1));
}

private static ArrayList<Integer> fillAListOfRandom(ArrayList<Integer> al, Integer amount) {
Random rnd = new Random();
for (int i = 0; i < amount; i++) {
al.add(rnd.nextInt(10, 100));
}
return al;
}

private static ArrayList<Integer> deleteFromAList(ArrayList<Integer> al1, ArrayList<Integer> al2) {
ArrayList<Integer> alWithDel = new ArrayList<>();

for (int i = 0; i < al1.size(); i++) {
if (al2.contains(al1.get(i)) && !alWithDel.contains(al1.get(i))) {
alWithDel.add(al1.get(i));
}
}

return alWithDel;
}

private static ArrayList<Integer> SortAList(ArrayList<Integer> al) {
ArrayList<Integer> alSorted = (ArrayList<Integer>) al.clone();
Collections.sort(alSorted);
return alSorted;
}

private static ArrayList<Integer> SortAListComparator(ArrayList<Integer> al) {
al.sort(new Comparator<Integer>() {
@Override
public int compare(Integer el0, Integer el1) {
return el1 - el0;
}
});
return al;
}

private static ArrayList<Integer> SortAListBubble(ArrayList<Integer> al) {
for (int i = 0; i < al.size(); i++) {
for (int j = 0; j < al.size() - 1; j++) {
if (al.get(j) > al.get(j + 1)) {
int tmp = al.get(j);
al.set(j, al.get(j + 1));
al.set(j + 1, tmp);
}
}
}
return al;
}
}
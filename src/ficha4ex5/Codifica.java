/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ficha4ex5;

/**
 *
 * @author tiago
 */
public class Codifica {

    public LinkedQueue<Character> save;
    public LinkedQueue<Integer> key;

    public Codifica(String key) {
        this.save = new LinkedQueue<>();
        this.key = new LinkedQueue<>();

        passarKey(key);
    }

    private void passarKey(String key) {
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {
            this.key.enqueue(Character.getNumericValue(keyArray[i]));
        }
    }

    public boolean codificar(String texto) throws EmptyCollectionException2 {
        if (texto == null) {
            return false;
        } else {
            char[] textoArray = texto.toCharArray();

            for (int i = 0; i < texto.length(); i++) {
                int k = key.dequeue();
                int ch = (int) textoArray[i];
                ch = ch + k;
                char c;
                c = (char) ch;

                this.save.enqueue(c);

            }

            return true;
        }
    }

    public String descodifica(String key) throws EmptyCollectionException2 {
        this.passarKey(key);
        char[] resultado = new char[key.length()];

        for (int i = 0; i < key.length(); i++) {
            char c = this.save.dequeue();

            int ch = (int) c;
            int k = this.key.dequeue();

            ch = ch - k;

            resultado[i] = (char) ch;
        }

        String string = new String(resultado);
        return string;
    }

}

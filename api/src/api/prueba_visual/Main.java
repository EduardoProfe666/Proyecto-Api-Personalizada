package api.prueba_visual;

import java.awt.EventQueue;

import api.prueba_visual.PruebaVisual;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PruebaVisual frame = new PruebaVisual();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

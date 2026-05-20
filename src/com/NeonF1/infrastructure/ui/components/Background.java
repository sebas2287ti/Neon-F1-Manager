    package com.NeonF1.infrastructure.ui.components;

    import javax.swing.*;
    import java.awt.*;
    import java.net.URL;

    public class Background extends JPanel {
        private Image ImageFondo;

        public Background(String Imagen) {

            URL UbicacionImagen = getClass().getResource(Imagen);

            if (UbicacionImagen != null) {
                this.ImageFondo = new ImageIcon(UbicacionImagen).getImage();
            }

            setOpaque(false);
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (ImageFondo != null) {
                g.drawImage(ImageFondo, 0, 0, getWidth(), getHeight(), this);
            } else {

                g.setColor(new Color(22, 27, 46));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

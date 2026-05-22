    package com.NeonF1.infrastructure.ui.components;

    import javax.swing.*;
    import java.awt.*;
    import java.net.URL;


    public class Background extends JPanel {
        private Image imageBackground;

        //Obtencion de la imagen apartir de la ubicacion en sources
        public Background(String locationImage) {

            URL urlLocationImage = getClass().getResource(locationImage);

            if (urlLocationImage != null) {
                this.imageBackground = new ImageIcon(urlLocationImage).getImage();
            }

            setOpaque(false);
        }

        //Encargado de pintar la imagen
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (imageBackground != null) {
                g.drawImage(imageBackground, 0, 0, getWidth(), getHeight(), this);
            } else {

                g.setColor(new Color(22, 27, 46));
                g.fillRect(0, 0, getWidth(), getHeight());
            }
        }
    }

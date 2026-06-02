/*
package hust.soict.dsai.aims.screen;

import java.awt.FlowLayout;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.LineBorder;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;

public class MediaStore extends JPanel {
	
	private Media media;
	private Cart cart;
	
	public MediaStore(Media media, Cart cart) {
		
		this.media = media;
		this.cart = cart;
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBorder(new LineBorder(Color.BLACK));
		
		JLabel title = new JLabel(media.getTitle());
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel("" + media.getCost() + "$");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		container.add(new JButton("Add to cart"));
		if (media instanceof Playable) {
			container.add(new JButton("Play"));
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}

}
*/

package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.cart.Cart; // Assuming you have a Cart class setup

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.BorderFactory;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart; // Keep a reference to the cart to add items

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBorder(new LineBorder(Color.BLACK));

        // Title
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.BOLD, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        // Cost
        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        // Container for buttons
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        // 1. Add to Cart Button & Event Handling
        JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                cart.addMedia(media); // Thêm sản phẩm vào cart chung
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "Added '" + media.getTitle() + "' to cart successfully!", 
                    "Cart Update", 
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
        });
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Interacts with console interface as requested
                cart.addMedia(media); 
                System.out.println("[SYSTEM]: " + media.getTitle() + " has been added to your cart.");
                System.out.println("Current Cart Size: " + cart.count());
            }
        });
        container.add(addToCartButton);

        // 2. Play Button & JDialog Event Handling (Only if media is Playable, like CD/DVD)
        if (media instanceof Playable) {
            JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    openPlayDialog();
                }
            });
            container.add(playButton);
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);
    }

    // Helper method to build and display the JDialog window
    private void openPlayDialog() {
        JDialog dialog = new JDialog();
        dialog.setTitle("Playing Media");
        dialog.setSize(400, 200);
        dialog.setModal(true); // Blocks interaction with the main screen until closed
        dialog.setLocationRelativeTo(this); // Centers the popup over the cell

        JPanel dialogPanel = new JPanel();
        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel playingLabel = new JLabel("Now Playing: " + media.getTitle());
        playingLabel.setFont(new Font(playingLabel.getFont().getName(), Font.BOLD, 16));
        playingLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Track length/info simulation string
        JLabel infoLabel = new JLabel("Media type: " + media.getClass().getSimpleName() + " | Cost: " + media.getCost() + "$");
        infoLabel.setAlignmentX(CENTER_ALIGNMENT);

        JButton closeButton = new JButton("Close");
        closeButton.setAlignmentX(CENTER_ALIGNMENT);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose(); // Closes the window cleanly
            }
        });

        dialogPanel.add(playingLabel);
        dialogPanel.add(Box.createVerticalStrut(10));
        dialogPanel.add(infoLabel);
        dialogPanel.add(Box.createVerticalGlue());
        dialogPanel.add(closeButton);

        dialog.add(dialogPanel);
        dialog.setVisible(true);
    }
}
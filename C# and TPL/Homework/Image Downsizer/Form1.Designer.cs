namespace Image_Downsizer
{
    partial class Form1
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.selectImageButton = new System.Windows.Forms.Button();
            this.downscaleButton = new System.Windows.Forms.Button();
            this.pictureBox = new System.Windows.Forms.PictureBox();
            this.downscaleFactorTextBox = new System.Windows.Forms.TextBox();
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).BeginInit();
            this.SuspendLayout();
            // 
            // selectImageButton
            // 
            this.selectImageButton.Location = new System.Drawing.Point(285, 357);
            this.selectImageButton.Name = "selectImageButton";
            this.selectImageButton.Size = new System.Drawing.Size(99, 23);
            this.selectImageButton.TabIndex = 0;
            this.selectImageButton.Text = "Select image";
            this.selectImageButton.UseVisualStyleBackColor = true;
            this.selectImageButton.Click += new System.EventHandler(this.selectImageButton_Click_1);
            // 
            // downscaleButton
            // 
            this.downscaleButton.Location = new System.Drawing.Point(406, 357);
            this.downscaleButton.Name = "downscaleButton";
            this.downscaleButton.Size = new System.Drawing.Size(75, 23);
            this.downscaleButton.TabIndex = 1;
            this.downscaleButton.Text = "Downscale";
            this.downscaleButton.UseVisualStyleBackColor = true;
            this.downscaleButton.Click += new System.EventHandler(this.downscaleButton_Click_1);
            // 
            // pictureBox
            // 
            this.pictureBox.Location = new System.Drawing.Point(181, 47);
            this.pictureBox.Name = "pictureBox";
            this.pictureBox.Size = new System.Drawing.Size(401, 224);
            this.pictureBox.TabIndex = 4;
            this.pictureBox.TabStop = false;
            // 
            // downscaleFactorTextBox
            // 
            this.downscaleFactorTextBox.Location = new System.Drawing.Point(341, 300);
            this.downscaleFactorTextBox.Name = "downscaleFactorTextBox";
            this.downscaleFactorTextBox.Size = new System.Drawing.Size(100, 23);
            this.downscaleFactorTextBox.TabIndex = 5;
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.downscaleFactorTextBox);
            this.Controls.Add(this.pictureBox);
            this.Controls.Add(this.downscaleButton);
            this.Controls.Add(this.selectImageButton);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Load += new System.EventHandler(this.Form1_Load);
            ((System.ComponentModel.ISupportInitialize)(this.pictureBox)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private Button selectImageButton;
        private Button downscaleButton;
        private PictureBox pictureBox;
        private TextBox downscaleFactorTextBox;
    }
}
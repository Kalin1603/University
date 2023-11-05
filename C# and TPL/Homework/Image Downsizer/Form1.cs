namespace Image_Downsizer
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void selectImageButton_Click_1(object sender, EventArgs e)
        {
            using (OpenFileDialog openFileDialog = new OpenFileDialog())
            {
                openFileDialog.Filter = "Image files|*.jpg;*.png;*.gif;*.bmp;*.jpeg";
                if (openFileDialog.ShowDialog() == DialogResult.OK)
                {
                    string selectedImagePath = openFileDialog.FileName;
                    pictureBox.Image = new Bitmap(selectedImagePath);
                }
            }
        }

        private void downscaleButton_Click_1(object sender, EventArgs e)
        {
            if (pictureBox.Image != null)
            {
                if (double.TryParse(downscaleFactorTextBox.Text, out double downscaleFactor) && downscaleFactor > 0)
                {
                    Bitmap originalImage = new Bitmap(pictureBox.Image);
                    Bitmap scaledImage = DownscaleImage(originalImage, downscaleFactor);
                    pictureBox.Image = scaledImage;
                }
                else
                {
                    MessageBox.Show("Моля, въведете валиден намаляващ фактор.");
                }
            }
            else
            {
                MessageBox.Show("Моля, изберете изображение първо.");
            }
        }

        private Bitmap DownscaleImage(Bitmap originalImage, double downscaleFactor)
        {
            int newWidth = (int)(originalImage.Width * (downscaleFactor / 100));
            int newHeight = (int)(originalImage.Height * (downscaleFactor / 100));
            Bitmap scaledImage = new Bitmap(newWidth, newHeight);

            for (int y = 0; y < newHeight; y++)
            {
                for (int x = 0; x < newWidth; x++)
                {
                    int originalX = (int)(x * (originalImage.Width / (double)newWidth));
                    int originalY = (int)(y * (originalImage.Height / (double)newHeight));

                    Color originalPixel = originalImage.GetPixel(originalX, originalY);
                    scaledImage.SetPixel(x, y, originalPixel);
                }
            }

            return scaledImage;
        }
    }
}
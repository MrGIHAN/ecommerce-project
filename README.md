# E-commerce Project

A full-featured e-commerce website built with modern web technologies, focusing on user experience, performance, and scalability.

## Features

- **User Authentication**: Secure sign-up and login functionality
- **Product Catalog**: Browse products with advanced filtering and search
- **Shopping Cart**: Add, remove, and update items in cart
- **Checkout Process**: Streamlined purchase flow with multiple payment options
- **Order Management**: Track order status and history
- **User Profiles**: Manage personal information and preferences
- **Admin Dashboard**: Comprehensive control panel for store management
- **Responsive Design**: Optimized for desktop, tablet, and mobile devices

## Tech Stack

- **Frontend**: React.js, Redux, Tailwind CSS
- **Backend**: Node.js, Express.js
- **Database**: MongoDB
- **Authentication**: JWT (JSON Web Tokens)
- **Payment Processing**: Stripe API integration
- **Cloud Storage**: AWS S3 for product images
- **Deployment**: Docker, CI/CD pipeline with GitHub Actions

## Prerequisites

- Node.js (v14.0.0 or newer)
- npm or yarn
- MongoDB (local or Atlas)
- AWS Account (for S3 storage)
- Stripe Account (for payment processing)

## Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/MrGIHAN/ecommerce-project.git
   cd ecommerce-project
   ```

2. Install dependencies:
   ```bash
   # Install backend dependencies
   cd server
   mvn spring-boot:run

   # Install frontend dependencies
   cd ../client
   npm install
   ```

3. Set up environment variables:
   - Create `.env` files in both `server` and `client` directories
   - Use the `.env.example` files as templates

4. Start development servers:
   ```bash
   # Start backend server
   cd server
   npm run dev

   # Start frontend development server
   cd ../client
   npm start
   ```

5. The application should now be running:
   - Backend API: http://localhost:5000
   - Frontend: http://localhost:3000

## Project Structure

```
ecommerce-project/
├── client/                 # Frontend React application
│   ├── public/             # Static files
│   ├── src/                # React source files
│   │   ├── components/     # Reusable React components
│   │   ├── pages/          # Page components
│   │   ├── redux/          # Redux store configuration
│   │   ├── services/       # API service functions
│   │   └── styles/         # CSS and styling files
├── server/                 # Backend Node.js/Express application
│   ├── config/             # Configuration files
│   ├── controllers/        # Route controllers
│   ├── models/             # Database models
│   ├── routes/             # API routes
│   ├── middlewares/        # Custom middleware functions
│   └── utils/              # Utility functions
├── .github/                # GitHub Actions workflow configurations
├── docker-compose.yml      # Docker Compose configuration
└── README.md               # Project documentation
```

## Configuration

### Environment Variables

#### Backend (.env in server directory)
```
NODE_ENV=development
PORT=5000
MONGO_URI=your_mongodb_connection_string
JWT_SECRET=your_jwt_secret_key
STRIPE_SECRET_KEY=your_stripe_secret_key
AWS_ACCESS_KEY_ID=your_aws_access_key
AWS_SECRET_ACCESS_KEY=your_aws_secret_key
AWS_BUCKET_NAME=your_s3_bucket_name
```

#### Frontend (.env in client directory)
```
REACT_APP_API_URL=http://localhost:5000/api
REACT_APP_STRIPE_PUBLIC_KEY=your_stripe_public_key
```

## Deployment

### Using Docker

1. Build and run using Docker Compose:
   ```bash
   docker-compose up --build
   ```

2. The application will be available at:
   - Frontend: http://localhost:3000
   - Backend API: http://localhost:5000

### Manual Deployment

#### Backend
1. Set up a production MongoDB instance
2. Configure environment variables for production
3. Build and start the server:
   ```bash
   cd server
   npm run build
   npm start
   ```

#### Frontend
1. Build the React application:
   ```bash
   cd client
   npm run build
   ```
2. Deploy the generated `build` folder to your web server or CDN

## Testing

Run tests for the backend:
```bash
cd server
npm test
```

Run tests for the frontend:
```bash
cd client
npm test
```

## API Documentation

The API documentation is available at `/api/docs` when the server is running.

## Contributing

1. Fork the repository
2. Create your feature branch: `git checkout -b feature/amazing-feature`
3. Commit your changes: `git commit -m 'Add some amazing feature'`
4. Push to the branch: `git push origin feature/amazing-feature`
5. Open a Pull Request

## License

This project is licensed under the MIT License - see the LICENSE file for details.

## Acknowledgments

- Hat tip to anyone whose code or libraries were used
- Inspiration from other e-commerce platforms
- Thanks to all contributors who have helped improve this project

Project Link: [https://github.com/MrGIHAN/ecommerce-project](https://github.com/MrGIHAN/ecommerce-project)

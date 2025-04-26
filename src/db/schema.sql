-- Users table
CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    first_name VARCHAR(100),
    last_name VARCHAR(100),
    role VARCHAR(20) NOT NULL, -- ADMIN, TEACHER, INDIVIDUAL_STUDENT, GROUP_STUDENT
    credits INTEGER DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Teacher profiles table
CREATE TABLE teacher_profiles (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    qualifications TEXT,
    experience TEXT,
    biography TEXT
);

-- Groups table
CREATE TABLE groups (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    created_by INTEGER REFERENCES users(id)
);

-- Group memberships table
CREATE TABLE group_memberships (
    id SERIAL PRIMARY KEY,
    group_id INTEGER REFERENCES groups(id),
    user_id INTEGER REFERENCES users(id),
    joined_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Time slots table
CREATE TABLE time_slots (
    id SERIAL PRIMARY KEY,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    name VARCHAR(50) -- 8-11, 11-14, 14-17, 17-20, 20-22
);

-- Availability table
CREATE TABLE availabilities (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    day_of_week INTEGER NOT NULL, -- 1-7 for Monday-Sunday
    time_slot_id INTEGER REFERENCES time_slots(id)
);

-- Bookings table
CREATE TABLE bookings (
    id SERIAL PRIMARY KEY,
    student_id INTEGER REFERENCES users(id),
    teacher_id INTEGER REFERENCES users(id),
    group_id INTEGER REFERENCES groups(id) NULL,
    day_of_week INTEGER NOT NULL,
    time_slot_id INTEGER REFERENCES time_slots(id),
    status VARCHAR(20) NOT NULL, -- SCHEDULED, COMPLETED, CANCELLED
    meeting_link VARCHAR(255),
    credits_used INTEGER DEFAULT 1,
    booking_date DATE
);

-- Credit transactions table
CREATE TABLE credit_transactions (
    id SERIAL PRIMARY KEY,
    user_id INTEGER REFERENCES users(id),
    amount INTEGER NOT NULL,
    type VARCHAR(20) NOT NULL, -- PURCHASE, USE, REFUND
    description TEXT,
    reference_id INTEGER -- booking_id or payment_id
);

-- Credit packages table
CREATE TABLE credit_packages (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    credits INTEGER NOT NULL,
    price DECIMAL(10,2) NOT NULL,
    description TEXT,
    is_active BOOLEAN DEFAULT TRUE
);
<script>
  import { browser } from '$app/environment';
  import { goto } from '$app/navigation';
  
  // Logic for signing in or signing up
  function navigateToLogin() {
    goto('/login');
  }
  
  function navigateToSignup() {
    goto('/signup');
  }
</script>

<div class="min-h-screen bg-gray-50">
  <!-- Navigation Bar -->
  <nav class="bg-white shadow-md">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="flex justify-between h-16">
        <div class="flex items-center">
          <div class="flex-shrink-0 flex items-center">
            <img class="h-8 w-8" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
            <span class="ml-2 text-xl font-bold text-talkup-blue">TalkUp</span>
          </div>
        </div>
        <!-- Mobile menu button -->
        <div class="flex items-center sm:hidden">
          <button type="button" class="inline-flex items-center justify-center p-2 rounded-md text-gray-400 hover:text-gray-500 hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-inset focus:ring-talkup-blue">
            <span class="sr-only">Open main menu</span>
            <svg class="block h-6 w-6" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" aria-hidden="true">
              <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M4 6h16M4 12h16M4 18h16" />
            </svg>
          </button>
        </div>
        <!-- Desktop navigation links -->
        <div class="hidden sm:flex sm:items-center">
          <div class="flex space-x-4">
            <a href="#features" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Features</a>
            <a href="#pricing" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Pricing</a>
            <a href="#testimonials" class="px-3 py-2 rounded-md text-sm font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Testimonials</a>
            <button on:click={navigateToLogin} class="px-3 py-2 rounded-md text-sm font-medium text-talkup-blue hover:text-blue-800 hover:bg-gray-50">Sign In</button>
            <button on:click={navigateToSignup} class="px-3 py-2 rounded-md text-sm font-medium bg-talkup-blue text-white hover:bg-blue-700">Sign Up</button>
          </div>
        </div>
      </div>
    </div>
    
    <!-- Mobile navigation menu (hidden by default) -->
    <div class="sm:hidden hidden" id="mobile-menu">
      <div class="px-2 pt-2 pb-3 space-y-1">
        <a href="#features" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Features</a>
        <a href="#pricing" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Pricing</a>
        <a href="#testimonials" class="block px-3 py-2 rounded-md text-base font-medium text-gray-700 hover:text-gray-900 hover:bg-gray-50">Testimonials</a>
        <button on:click={navigateToLogin} class="block w-full text-left px-3 py-2 rounded-md text-base font-medium text-talkup-blue hover:text-blue-800 hover:bg-gray-50">Sign In</button>
        <button on:click={navigateToSignup} class="block w-full text-left px-3 py-2 rounded-md text-base font-medium bg-talkup-blue text-white hover:bg-blue-700">Sign Up</button>
      </div>
    </div>
  </nav>
  
  <!-- Hero Section -->
  <div class="relative bg-white overflow-hidden">
    <div class="max-w-7xl mx-auto">
      <div class="relative z-10 pb-8 bg-white sm:pb-16 md:pb-20 lg:max-w-2xl lg:w-full lg:pb-28 xl:pb-32">
        <main class="mt-10 mx-auto max-w-7xl px-4 sm:mt-12 sm:px-6 lg:mt-16 lg:px-8 xl:mt-20">
          <div class="sm:text-center lg:text-left">
            <h1 class="text-3xl tracking-tight font-extrabold text-gray-900 sm:text-4xl md:text-5xl">
              <span class="block">Improve your</span>
              <span class="block text-talkup-blue">language skills</span>
            </h1>
            <p class="mt-3 text-base text-gray-500 sm:mt-5 sm:text-lg sm:max-w-xl sm:mx-auto md:mt-5 md:text-xl lg:mx-0">
              Connect with native speakers and professional teachers for real conversations. Practice anytime, anywhere with TalkUp.
            </p>
            <div class="mt-5 sm:mt-8 sm:flex sm:justify-center lg:justify-start">
              <div class="rounded-md shadow">
                <button on:click={navigateToSignup} class="w-full flex items-center justify-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-white bg-talkup-blue hover:bg-blue-700 md:py-3 md:text-lg md:px-8">
                  Get started
                </button>
              </div>
              <div class="mt-3 sm:mt-0 sm:ml-3">
                <a href="#how-it-works" class="w-full flex items-center justify-center px-6 py-3 border border-transparent text-base font-medium rounded-md text-talkup-blue bg-blue-100 hover:bg-blue-200 md:py-3 md:text-lg md:px-8">
                  Learn more
                </a>
              </div>
            </div>
          </div>
        </main>
      </div>
    </div>
    <div class="lg:absolute lg:inset-y-0 lg:right-0 lg:w-1/2">
      <img class="h-56 w-full object-cover sm:h-72 md:h-96 lg:w-full lg:h-full" src="https://picsum.photos/seed/language/1200/800" alt="Language Learning">
    </div>
  </div>
  
  <!-- How it Works Section -->
  <div id="how-it-works" class="py-10 bg-white sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">How It Works</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Learn languages through conversation
        </p>
        <p class="mt-4 max-w-2xl text-lg text-gray-500 lg:mx-auto">
          Our platform connects you with qualified teachers for personalized language practice.
        </p>
      </div>
      
      <div class="mt-10">
        <div class="space-y-8 sm:space-y-10 md:space-y-0 md:grid md:grid-cols-1 md:gap-y-8 lg:grid-cols-3 lg:gap-x-8">
          <!-- Step 1 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 10h18M7 15h1m4 0h1m-7 4h12a3 3 0 003-3V8a3 3 0 00-3-3H6a3 3 0 00-3 3v8a3 3 0 003 3z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Purchase Credits</h3>
              <p class="mt-2 text-base text-gray-500">
                Buy credit packages to unlock conversation sessions with our teachers.
              </p>
            </div>
          </div>
          
          <!-- Step 2 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8 7V3m8 4V3m-9 8h10M5 21h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v12a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Book Sessions</h3>
              <p class="mt-2 text-base text-gray-500">
                Schedule sessions with teachers based on your availability.
              </p>
            </div>
          </div>
          
          <!-- Step 3 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 10l4.553-2.276A1 1 0 0121 8.618v6.764a1 1 0 01-1.447.894L15 14M5 18h8a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Practice & Improve</h3>
              <p class="mt-2 text-base text-gray-500">
                Join virtual sessions and improve your language skills through real conversations.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Features Section -->
  <div id="features" class="py-10 bg-gray-50 sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">Features</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Everything you need to learn effectively
        </p>
      </div>
      
      <div class="mt-10">
        <div class="space-y-8 md:space-y-0 md:grid md:grid-cols-1 lg:grid-cols-2 md:gap-x-8 md:gap-y-8">
          <!-- Feature 1 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4.354a4 4 0 110 5.292M15 21H3v-1a6 6 0 0112 0v1zm0 0h6v-1a6 6 0 00-9-5.197M13 7a4 4 0 11-8 0 4 4 0 018 0z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Professional Teachers</h3>
              <p class="mt-2 text-base text-gray-500">
                Learn from qualified teachers who are native speakers or fluent in multiple languages.
              </p>
            </div>
          </div>
          
          <!-- Feature 2 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Flexible Scheduling</h3>
              <p class="mt-2 text-base text-gray-500">
                Book sessions at times that work for you, with our easy-to-use scheduling system.
              </p>
            </div>
          </div>
          
          <!-- Feature 3 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 10l4.553-2.276A1 1 0 0121 8.618v6.764a1 1 0 01-1.447.894L15 14M5 18h8a2 2 0 002-2V8a2 2 0 00-2-2H5a2 2 0 00-2 2v8a2 2 0 002 2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Virtual Classrooms</h3>
              <p class="mt-2 text-base text-gray-500">
                Join sessions from anywhere with our integrated video conferencing solution.
              </p>
            </div>
          </div>
          
          <!-- Feature 4 -->
          <div class="relative">
            <div class="absolute flex items-center justify-center h-10 w-10 rounded-md bg-talkup-blue text-white">
              <svg class="h-5 w-5" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z" />
              </svg>
            </div>
            <div class="ml-14">
              <h3 class="text-lg leading-6 font-medium text-gray-900">Progress Tracking</h3>
              <p class="mt-2 text-base text-gray-500">
                Monitor your language learning progress with detailed feedback after each session.
              </p>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Pricing Section -->
  <div id="pricing" class="py-10 bg-white sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">Pricing</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          Credit Packages
        </p>
        <p class="mt-4 max-w-2xl text-lg text-gray-500 mx-auto">
          Choose the package that fits your learning needs and budget.
        </p>
      </div>
      
      <div class="mt-8 space-y-4 sm:mt-10 sm:space-y-6 lg:space-y-0 lg:grid lg:grid-cols-3 lg:gap-x-6">
        <!-- Basic Package -->
        <div class="relative p-5 bg-white border border-gray-200 rounded-lg shadow-sm flex flex-col">
          <div class="flex-1">
            <h3 class="text-lg font-semibold text-gray-900">Basic Package</h3>
            <p class="mt-4 flex items-baseline text-gray-900">
              <span class="text-3xl font-extrabold tracking-tight">$49.99</span>
            </p>
            <p class="mt-4 text-sm text-gray-500">Perfect for beginners looking to try out the platform.</p>
            
            <!-- Feature list -->
            <ul role="list" class="mt-6 space-y-3">
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">10 Credits</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">30-day validity</span>
              </li>
            </ul>
          </div>
          
          <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-blue py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-blue-700">
            Get Started
          </button>
        </div>
        
        <!-- Standard Package -->
        <div class="relative p-5 bg-white border-2 border-talkup-blue rounded-lg shadow-sm flex flex-col">
          <div class="absolute -top-4 inset-x-0">
            <div class="inline-block px-4 py-1 text-sm font-semibold text-white bg-talkup-orange rounded-full transform -translate-y-1/2">
              Most Popular
            </div>
          </div>
          <div class="flex-1">
            <h3 class="text-lg font-semibold text-gray-900">Standard Package</h3>
            <p class="mt-4 flex items-baseline text-gray-900">
              <span class="text-3xl font-extrabold tracking-tight">$89.99</span>
            </p>
            <p class="mt-4 text-sm text-gray-500">Most popular choice for regular learners.</p>
            
            <!-- Feature list -->
            <ul role="list" class="mt-6 space-y-3">
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">20 Credits</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">60-day validity</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">Progress reports</span>
              </li>
            </ul>
          </div>
          
          <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-orange py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-orange-600">
            Get Started
          </button>
        </div>
        
        <!-- Premium Package -->
        <div class="relative p-5 bg-white border border-gray-200 rounded-lg shadow-sm flex flex-col">
          <div class="flex-1">
            <h3 class="text-lg font-semibold text-gray-900">Premium Package</h3>
            <p class="mt-4 flex items-baseline text-gray-900">
              <span class="text-3xl font-extrabold tracking-tight">$199.99</span>
            </p>
            <p class="mt-4 text-sm text-gray-500">Best value for serious language learners.</p>
            
            <!-- Feature list -->
            <ul role="list" class="mt-6 space-y-3">
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">50 Credits</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">1 credit = 1 session</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">90-day validity</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">Priority booking</span>
              </li>
              <li class="flex items-start">
                <svg class="flex-shrink-0 w-4 h-4 mt-1 text-talkup-blue" fill="none" viewBox="0 0 24 24" stroke="currentColor">
                  <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7" />
                </svg>
                <span class="ml-2 text-sm text-gray-500">Detailed progress reports</span>
              </li>
            </ul>
          </div>
          
          <button on:click={navigateToSignup} class="mt-6 block w-full bg-talkup-blue py-2 px-4 border border-transparent rounded-md text-center font-medium text-white hover:bg-blue-700">
            Get Started
          </button>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Testimonials Section -->
  <div id="testimonials" class="py-10 bg-gray-50 sm:py-12">
    <div class="max-w-7xl mx-auto px-4 sm:px-6 lg:px-8">
      <div class="lg:text-center">
        <h2 class="text-base text-talkup-blue font-semibold tracking-wide uppercase">Testimonials</h2>
        <p class="mt-2 text-2xl leading-8 font-extrabold tracking-tight text-gray-900 sm:text-3xl">
          What our students say
        </p>
      </div>
      
      <div class="mt-8 space-y-6 lg:mt-10 lg:space-y-0 lg:grid lg:grid-cols-3 lg:gap-6">
        <!-- Testimonial 1 -->
        <div class="lg:col-span-1">
          <div class="h-full bg-white rounded-lg shadow overflow-hidden p-5">
            <div class="h-full flex flex-col justify-between">
              <div>
                <div class="flex items-center">
                  <div class="flex-shrink-0">
                    <img class="h-10 w-10 rounded-full" src="https://picsum.photos/seed/user1/100/100" alt="User">
                  </div>
                  <div class="ml-3">
                    <h4 class="text-base font-medium text-gray-900">Sarah Johnson</h4>
                    <p class="text-xs text-gray-500">Spanish Learner</p>
                  </div>
                </div>
                <div class="mt-3 text-sm text-gray-600">
                  <p>"TalkUp has transformed my language learning journey. The teachers are amazing and the flexibility to book sessions at my convenience is perfect for my busy schedule."</p>
                </div>
              </div>
              <div class="mt-4 flex items-center">
                <div class="flex text-yellow-400">
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Testimonial 2 -->
        <div class="lg:col-span-1">
          <div class="h-full bg-white rounded-lg shadow overflow-hidden p-5">
            <div class="h-full flex flex-col justify-between">
              <div>
                <div class="flex items-center">
                  <div class="flex-shrink-0">
                    <img class="h-10 w-10 rounded-full" src="https://picsum.photos/seed/user2/100/100" alt="User">
                  </div>
                  <div class="ml-3">
                    <h4 class="text-base font-medium text-gray-900">Michael Chen</h4>
                    <p class="text-xs text-gray-500">French Learner</p>
                  </div>
                </div>
                <div class="mt-3 text-sm text-gray-600">
                  <p>"I've tried many language platforms, but TalkUp is different. The one-on-one conversations with real teachers have improved my speaking skills dramatically in just a few weeks."</p>
                </div>
              </div>
              <div class="mt-4 flex items-center">
                <div class="flex text-yellow-400">
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
        </div>
        
        <!-- Testimonial 3 -->
        <div class="lg:col-span-1">
          <div class="h-full bg-white rounded-lg shadow overflow-hidden p-5">
            <div class="h-full flex flex-col justify-between">
              <div>
                <div class="flex items-center">
                  <div class="flex-shrink-0">
                    <img class="h-10 w-10 rounded-full" src="https://picsum.photos/seed/user3/100/100" alt="User">
                  </div>
                  <div class="ml-3">
                    <h4 class="text-base font-medium text-gray-900">Elena Rodriguez</h4>
                    <p class="text-xs text-gray-500">English Learner</p>
                  </div>
                </div>
                <div class="mt-3 text-sm text-gray-600">
                  <p>"The credit system makes it easy to manage my budget, and the teachers are so patient and supportive. My confidence in speaking English has grown tremendously!"</p>
                </div>
              </div>
              <div class="mt-4 flex items-center">
                <div class="flex text-yellow-400">
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                  <svg class="h-4 w-4" fill="currentColor" viewBox="0 0 20 20">
                    <path d="M9.049 2.927c.3-.921 1.603-.921 1.902 0l1.07 3.292a1 1 0 00.95.69h3.462c.969 0 1.371 1.24.588 1.81l-2.8 2.034a1 1 0 00-.364 1.118l1.07 3.292c.3.921-.755 1.688-1.54 1.118l-2.8-2.034a1 1 0 00-1.175 0l-2.8 2.034c-.784.57-1.838-.197-1.539-1.118l1.07-3.292a1 1 0 00-.364-1.118L2.98 8.72c-.783-.57-.38-1.81.588-1.81h3.461a1 1 0 00.951-.69l1.07-3.292z" />
                  </svg>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  
  <!-- CTA Section -->
  <div class="bg-talkup-blue">
    <div class="max-w-7xl mx-auto py-8 px-4 sm:px-6 lg:py-12 lg:px-8 lg:flex lg:items-center lg:justify-between">
      <h2 class="text-2xl font-extrabold tracking-tight text-white sm:text-3xl">
        <span class="block">Ready to improve your language skills?</span>
        <span class="block text-talkup-orange">Start your journey today.</span>
      </h2>
      <div class="mt-6 flex flex-col sm:flex-row sm:space-x-3 lg:mt-0 lg:flex-shrink-0">
        <div class="mb-3 sm:mb-0">
          <button on:click={navigateToSignup} class="w-full flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-talkup-blue bg-white hover:bg-gray-50">
            Get started
          </button>
        </div>
        <div>
          <button on:click={navigateToLogin} class="w-full flex items-center justify-center px-4 py-2 border border-transparent rounded-md shadow-sm text-base font-medium text-white bg-talkup-orange hover:bg-orange-600">
            Sign in
          </button>
        </div>
      </div>
    </div>
  </div>
  
  <!-- Footer -->
  <footer class="bg-gray-800">
    <div class="max-w-7xl mx-auto py-12 px-4 overflow-hidden sm:px-6 lg:px-8">
      <div class="grid grid-cols-1 gap-8 sm:grid-cols-2 lg:grid-cols-4">
        <div>
          <div class="flex items-center">
            <img class="h-8 w-8" src="https://picsum.photos/seed/talkup/32/32.jpg" alt="TalkUp Logo" />
            <span class="ml-2 text-xl font-bold text-white">TalkUp</span>
          </div>
          <p class="mt-4 text-sm text-gray-300">
            Connecting language learners with professional teachers for meaningful conversations and effective learning.
          </p>
          <div class="mt-4 flex space-x-4">
            <a href="#" class="text-gray-400 hover:text-gray-300">
              <span class="sr-only">Facebook</span>
              <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                <path fill-rule="evenodd" d="M22 12c0-5.523-4.477-10-10-10S2 6.477 2 12c0 4.991 3.657 9.128 8.438 9.878v-6.987h-2.54V12h2.54V9.797c0-2.506 1.492-3.89 3.777-3.89 1.094 0 2.238.195 2.238.195v2.46h-1.26c-1.243 0-1.63.771-1.63 1.562V12h2.773l-.443 2.89h-2.33v6.988C18.343 21.128 22 16.991 22 12z" clip-rule="evenodd" />
              </svg>
            </a>
            <a href="#" class="text-gray-400 hover:text-gray-300">
              <span class="sr-only">Instagram</span>
              <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                <path fill-rule="evenodd" d="M12.315 2c2.43 0 2.784.013 3.808.06 1.064.049 1.791.218 2.427.465a4.902 4.902 0 011.772 1.153 4.902 4.902 0 011.153 1.772c.247.636.416 1.363.465 2.427.048 1.067.06 1.407.06 4.123v.08c0 2.643-.012 2.987-.06 4.043-.049 1.064-.218 1.791-.465 2.427a4.902 4.902 0 01-1.153 1.772 4.902 4.902 0 01-1.772 1.153c-.636.247-1.363.416-2.427.465-1.067.048-1.407.06-4.123.06h-.08c-2.643 0-2.987-.012-4.043-.06-1.064-.049-1.791-.218-2.427-.465a4.902 4.902 0 01-1.772-1.153 4.902 4.902 0 01-1.153-1.772c-.247-.636-.416-1.363-.465-2.427-.047-1.024-.06-1.379-.06-3.808v-.63c0-2.43.013-2.784.06-3.808.049-1.064.218-1.791.465-2.427a4.902 4.902 0 011.153-1.772A4.902 4.902 0 015.45 2.525c.636-.247 1.363-.416 2.427-.465C8.901 2.013 9.256 2 11.685 2h.63zm-.081 1.802h-.468c-2.456 0-2.784.011-3.807.058-.975.045-1.504.207-1.857.344-.467.182-.8.398-1.15.748-.35.35-.566.683-.748 1.15-.137.353-.3.882-.344 1.857-.047 1.023-.058 1.351-.058 3.807v.468c0 2.456.011 2.784.058 3.807.045.975.207 1.504.344 1.857.182.466.399.8.748 1.15.35.35.683.566 1.15.748.353.137.882.3 1.857.344 1.054.048 1.37.058 4.041.058h.08c2.597 0 2.917-.01 3.96-.058.976-.045 1.505-.207 1.858-.344.466-.182.8-.398 1.15-.748.35-.35.566-.683.748-1.15.137-.353.3-.882.344-1.857.048-1.055.058-1.37.058-4.041v-.08c0-2.597-.01-2.917-.058-3.96-.045-.976-.207-1.505-.344-1.858a3.097 3.097 0 00-.748-1.15 3.098 3.098 0 00-1.15-.748c-.353-.137-.882-.3-1.857-.344-1.023-.047-1.351-.058-3.807-.058zM12 6.865a5.135 5.135 0 110 10.27 5.135 5.135 0 010-10.27zm0 1.802a3.333 3.333 0 100 6.666 3.333 3.333 0 000-6.666zm5.338-3.205a1.2 1.2 0 110 2.4 1.2 1.2 0 010-2.4z" clip-rule="evenodd" />
              </svg>
            </a>
            <a href="#" class="text-gray-400 hover:text-gray-300">
              <span class="sr-only">Twitter</span>
              <svg class="h-5 w-5" fill="currentColor" viewBox="0 0 24 24" aria-hidden="true">
                <path d="M8.29 20.251c7.547 0 11.675-6.253 11.675-11.675 0-.178 0-.355-.012-.53A8.348 8.348 0 0022 5.92a8.19 8.19 0 01-2.357.646 4.118 4.118 0 001.804-2.27 8.224 8.224 0 01-2.605.996 4.107 4.107 0 00-6.993 3.743 11.65 11.65 0 01-8.457-4.287 4.106 4.106 0 001.27 5.477A4.072 4.072 0 012.8 9.713v.052a4.105 4.105 0 003.292 4.022 4.095 4.095 0 01-1.853.07 4.108 4.108 0 003.834 2.85A8.233 8.233 0 012 18.407a11.616 11.616 0 006.29 1.84" />
              </svg>
            </a>
          </div>
        </div>
        
        <div>
          <h3 class="text-sm font-semibold text-gray-400 tracking-wider uppercase">Platform</h3>
          <ul role="list" class="mt-4 space-y-3">
            <li>
              <a href="#how-it-works" class="text-sm text-gray-300 hover:text-white">How it works</a>
            </li>
            <li>
              <a href="#pricing" class="text-sm text-gray-300 hover:text-white">Pricing</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Teachers</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Languages</a>
            </li>
          </ul>
        </div>
        
        <div>
          <h3 class="text-sm font-semibold text-gray-400 tracking-wider uppercase">Support</h3>
          <ul role="list" class="mt-4 space-y-3">
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">FAQ</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Contact Us</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Help Center</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Become a Teacher</a>
            </li>
          </ul>
        </div>
        
        <div>
          <h3 class="text-sm font-semibold text-gray-400 tracking-wider uppercase">Legal</h3>
          <ul role="list" class="mt-4 space-y-3">
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Privacy Policy</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Terms of Service</a>
            </li>
            <li>
              <a href="#" class="text-sm text-gray-300 hover:text-white">Cookie Policy</a>
            </li>
          </ul>
        </div>
      </div>
      
      <div class="mt-8 pt-8 border-t border-gray-700">
        <p class="text-sm text-gray-400 text-center">
          &copy; 2025 TalkUp Language Platform. All rights reserved.
        </p>
      </div>
    </div>
  </footer>
  
  <!-- Mobile Navigation Script -->
  <script>
    if (browser) {
      const mobileMenuButton = document.querySelector('[aria-label="Open main menu"]');
      const mobileMenu = document.getElementById('mobile-menu');
      
      if (mobileMenuButton && mobileMenu) {
        mobileMenuButton.addEventListener('click', () => {
          const expanded = mobileMenuButton.getAttribute('aria-expanded') === 'true';
          mobileMenuButton.setAttribute('aria-expanded', !expanded);
          mobileMenu.classList.toggle('hidden');
        });
      }
    }
  </script>
</div>
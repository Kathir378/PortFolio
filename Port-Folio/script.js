
        // Create sparks
        const sparkContainer = document.querySelector('.spark-container');
        const sparkCount = 100;
        
        for (let i = 0; i < sparkCount; i++) {
            const spark = document.createElement('div');
            spark.classList.add('spark');
            sparkContainer.appendChild(spark);
            animateSpark(spark);
        }
        
        function animateSpark(spark) {
            // Random position
            const x = Math.random() * window.innerWidth;
            const y = Math.random() * window.innerHeight;
            
            // Random size
            const size = Math.random() * 4 + 1;
            
            // Random color
            const colors = ['rgba(255, 107, 157, 0.8)', 'rgba(138, 43, 226, 0.8)', 'rgba(75, 0, 130, 0.8)'];
            const color = colors[Math.floor(Math.random() * colors.length)];
            
            // Set properties
            spark.style.width = `${size}px`;
            spark.style.height = `${size}px`;
            spark.style.left = `${x}px`;
            spark.style.top = `${y}px`;
            spark.style.backgroundColor = color;
            spark.style.boxShadow = `0 0 ${size * 3}px ${size}px ${color}`;
            
            // Animate
            const duration = Math.random() * 3 + 2;
            const delay = Math.random() * 5;
            
            spark.animate([
                { opacity: 0, transform: 'translate(0, 0)' },
                { opacity: 1, transform: `translate(${Math.random() * 100 - 50}px, ${Math.random() * 100 - 50}px)` },
                { opacity: 0, transform: `translate(${Math.random() * 200 - 100}px, ${Math.random() * 200 - 100}px)` }
            ], {
                duration: duration * 1000,
                delay: delay * 1000,
                easing: 'cubic-bezier(0.4, 0, 0.2, 1)',
                iterations: Infinity
            });
        }
        
        // Profile photo particles
        const particleContainer = document.getElementById('profile-particles');
        const particleCount = 30;
        
        for (let i = 0; i < particleCount; i++) {
            createProfileParticle();
        }
        
        function createProfileParticle() {
            const particle = document.createElement('div');
            particle.classList.add('particle');
            particleContainer.appendChild(particle);
            
            // Random angle and distance from center
            const angle = Math.random() * Math.PI * 2;
            const distance = 120 + Math.random() * 30;
            const x = Math.cos(angle) * distance;
            const y = Math.sin(angle) * distance;
            
            // Random size
            const size = Math.random() * 6 + 2;
            
            // Random color
            const colors = ['rgba(255, 107, 157, 0.8)', 'rgba(138, 43, 226, 0.8)', 'rgba(75, 0, 130, 0.8)'];
            const color = colors[Math.floor(Math.random() * colors.length)];
            
            // Set properties
            particle.style.width = `${size}px`;
            particle.style.height = `${size}px`;
            particle.style.left = `calc(50% + ${x}px)`;
            particle.style.top = `calc(50% + ${y}px)`;
            particle.style.backgroundColor = color;
            particle.style.boxShadow = `0 0 ${size * 2}px ${size / 2}px ${color}`;
            
            // Animate
            const duration = Math.random() * 4 + 3;
            const delay = Math.random() * 2;
            
            particle.animate([
                { 
                    transform: `translate(0, 0) scale(1)`,
                    opacity: 0.2
                },
                { 
                    transform: `translate(${Math.random() * 40 - 20}px, ${Math.random() * 40 - 20}px) scale(${Math.random() * 0.5 + 0.8})`,
                    opacity: 1
                },
                { 
                    transform: `translate(${Math.random() * 40 - 20}px, ${Math.random() * 40 - 20}px) scale(${Math.random() * 0.5 + 0.8})`,
                    opacity: 0.2
                }
            ], {
                duration: duration * 1000,
                delay: delay * 1000,
                easing: 'cubic-bezier(0.4, 0, 0.2, 1)',
                iterations: Infinity,
                direction: 'alternate'
            });
            
            // Recreate particle after animation ends to ensure continuous effect
            setTimeout(() => {
                if (particle.parentNode === particleContainer) {
                    particleContainer.removeChild(particle);
                    createProfileParticle();
                }
            }, (duration * 1000 * 2) + (delay * 1000));
        }
        
        // Check if element is in viewport
        function isInViewport(element) {
            const rect = element.getBoundingClientRect();
            return (
                rect.top <= (window.innerHeight || document.documentElement.clientHeight) * 0.8
            );
        }
        
        // Handle scroll animations
        function handleScroll() {
            // Animate sections
            document.querySelectorAll('.about, .projects, .skills, .contact').forEach(section => {
                if (isInViewport(section)) {
                    section.classList.add('visible');
                }
            });
            
            // Animate project cards with delay
            document.querySelectorAll('.project-card').forEach((card, index) => {
                if (isInViewport(card)) {
                    setTimeout(() => {
                        card.classList.add('visible');
                    }, index * 200);
                }
            });
            
            // Animate skill items with delay
            document.querySelectorAll('.skill-item').forEach((item, index) => {
                if (isInViewport(item)) {
                    setTimeout(() => {
                        item.classList.add('visible');
                        const progressBar = item.querySelector('.skill-progress');
                        const width = progressBar.getAttribute('data-width');
                        progressBar.style.width = `${width}%`;
                    }, index * 150);
                }
            });
        }
        
        // Initial check
        window.addEventListener('load', handleScroll);
        
        // Listen for scroll
        window.addEventListener('scroll', handleScroll);
        
        // Smooth scroll for navigation
        document.querySelectorAll('a[href^="#"]').forEach(anchor => {
            anchor.addEventListener('click', function(e) {
                e.preventDefault();
                
                const targetId = this.getAttribute('href');
                const targetElement = document.querySelector(targetId);
                
                window.scrollTo({
                    top: targetElement.offsetTop - 80,
                    behavior: 'smooth'
                });
            });
        });
        
         function handleScroll() {
            // Animate sections
            document.querySelectorAll('.about, .projects, .skills, .contact').forEach(section => {
                if (isInViewport(section)) {
                    section.classList.add('visible');
                }
            });
            
            // Animate project cards with delay
            document.querySelectorAll('.project-card').forEach((card, index) => {
                if (isInViewport(card)) {
                    setTimeout(() => {
                        card.classList.add('visible');
                    }, index * 200);
                }
            });
            
            // Animate skill items with delay
            document.querySelectorAll('.skill-item').forEach((item, index) => {
                if (isInViewport(item)) {
                    setTimeout(() => {
                        item.classList.add('visible');
                    }, index * 150);
                }
            });
        }

        // Form submission
        const contactForm = document.getElementById('contactForm');
        const successMessage = document.getElementById('successMessage');
        
        if (contactForm) {
            contactForm.addEventListener('submit', function(e) {
                e.preventDefault();
                
                // Simulate form submission
                contactForm.style.opacity = '0.5';
                contactForm.style.pointerEvents = 'none';
                
                // Show success message after delay
                setTimeout(() => {
                    contactForm.style.display = 'none';
                    successMessage.style.display = 'block';
                    
                    // Reset form after some time
                    setTimeout(() => {
                        contactForm.reset();
                        contactForm.style.display = 'block';
                        contactForm.style.opacity = '1';
                        contactForm.style.pointerEvents = 'auto';
                        successMessage.style.display = 'none';
                    }, 3000);
                }, 1500);
            });
        }





  document.addEventListener("DOMContentLoaded", function () {
        const toolsItems = document.querySelectorAll(".tools-item");

        const observer = new IntersectionObserver(entries => {
            entries.forEach((entry, index) => {
                if (entry.isIntersecting) {
                    setTimeout(() => {
                        entry.target.classList.add("show");
                    }, index * 300); // Staggered effect
                }
            });
        }, { threshold: 0.3 });

        toolsItems.forEach(item => {
            observer.observe(item);
        });
    });
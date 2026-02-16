from setuptools import setup, find_packages

setup(
    name='apiverve_birthstones',
    version='1.1.14',
    packages=find_packages(),
    include_package_data=True,
    install_requires=[
        'requests',
        'setuptools'
    ],
    description='Birthstones is a comprehensive lookup API for birthstone information. It returns detailed data about gemstones associated with each birth month, including the primary stone, alternate stones, colors, meanings, and zodiac associations.',
    author='APIVerve',
    author_email='hello@apiverve.com',
    url='https://apiverve.com/marketplace/birthstones?utm_source=pypi&utm_medium=homepage',
    classifiers=[
        'Programming Language :: Python :: 3',
        'Operating System :: OS Independent',
    ],
    python_requires='>=3.6',
)
